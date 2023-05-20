package ru.itis.deshevin.mappers;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ru.itis.deshevin.dto.AddDrugDto;
import ru.itis.deshevin.dto.DrugDto;
import ru.itis.deshevin.models.DrugEntity;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DrugMapper {

    @Mapping(target = "category.id", source = "categoryId")
    @Mapping(target = "analogueClass.id", source = "analogueId")
    DrugEntity toDrugEntity(AddDrugDto addDrugDto);

    @Mapping(target = "category", source = "category.title")
    @Mapping(target = "analogueClass", source = "analogueClass.title")
    DrugDto toDrugDto(DrugEntity drugEntity);

    List<DrugDto> toDrugListDto(List<DrugEntity> drugEntityList);
}
