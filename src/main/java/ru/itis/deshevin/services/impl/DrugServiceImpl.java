package ru.itis.deshevin.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.itis.deshevin.dto.AddDrugDto;
import ru.itis.deshevin.dto.DrugDto;
import ru.itis.deshevin.mappers.DrugMapper;
import ru.itis.deshevin.models.AnalogueClassEntity;
import ru.itis.deshevin.models.CategoryEntity;
import ru.itis.deshevin.models.DrugEntity;
import ru.itis.deshevin.repositories.DrugRepository;
import ru.itis.deshevin.services.DrugService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class DrugServiceImpl implements DrugService {

    private final DrugMapper drugMapper;
    private final DrugRepository drugRepository;
    @Override
    @Transactional
    public void saveDrug(AddDrugDto addDrugDto) {
        log.info("Start saving drug = " + addDrugDto);
        drugRepository.save(drugMapper.toDrugEntity(addDrugDto));
        log.info("Finish saving drug");

    }

    @Override
    @Transactional
    public void updateDrug(AddDrugDto addDrugDto, UUID id) {
        log.info("Start updating drug with id = "+ id +" "+addDrugDto);
        DrugEntity drugEntity = drugRepository.findById(id).orElseGet(DrugEntity::new);
        if (addDrugDto.getAnalogueId() != null) {
            drugEntity.setAnalogueClass(
                    AnalogueClassEntity
                            .builder()
                            .id(addDrugDto.getAnalogueId())
                            .build()
            );
        }
        if (addDrugDto.getCategoryId() != null) {
            drugEntity.setCategory(
                    CategoryEntity
                            .builder()
                            .id(addDrugDto.getCategoryId())
                            .build()
            );
        }
        drugEntity.setTitle(addDrugDto.getTitle());
        drugEntity.setDescription(addDrugDto.getDescription());
        drugRepository.save(drugEntity);
        log.info("Finish updating drug");
    }

    @Override
    public List<DrugDto> getAllDrugs() {
        log.info("Get all drug info ...");
        return drugMapper.toDrugListDto(drugRepository.findAll());
    }

    @Override
    public DrugDto getDrugById(UUID id) {
        return drugMapper.toDrugDto(drugRepository.findById(id).orElseGet(DrugEntity::new));
    }

    @Override
    public void deleteDrugBuId(UUID id) {
        log.info("Start deleting drug with id = " + id);
        drugRepository.deleteById(id);
        log.info("Finish deleting drug");

    }


}