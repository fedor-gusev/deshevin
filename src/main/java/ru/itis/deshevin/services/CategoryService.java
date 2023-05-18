package ru.itis.deshevin.services;

import ru.itis.deshevin.dto.CategoryDto;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<CategoryDto> getAllCategory();

    void saveCategory(CategoryDto categoryDto);

    void deleteCategory(UUID id);
}
