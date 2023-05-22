package ru.itis.deshevin.services;

import ru.itis.deshevin.dto.DrugDto;

import java.util.List;
import java.util.UUID;

public interface SearchService {

    List<DrugDto> getDrugsForPreview();

    List<DrugDto> getDrugsByNameStartsWith(String prefix);

    List<DrugDto> getDrugsWithSameAnalogueClassAs(UUID drugId);

    List<DrugDto> getDrugsWithSameCategoryAs(UUID drugId);

}
