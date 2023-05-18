package ru.itis.deshevin.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ru.itis.deshevin.dto.CategoryDto;
import ru.itis.deshevin.mappers.CategoryMapper;
import ru.itis.deshevin.repositories.CategoryRepository;

import java.util.List;
import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    public List<CategoryDto> getAllCategory() {
        log.info("Get all categories");
        return categoryMapper.toCategoryDtoList(categoryRepository.findAll());
    }

    @Override
    public void saveCategory(CategoryDto categoryDto) {
        log.info("Saving Category " + categoryDto);
        categoryRepository.save(categoryMapper.toCategoryEntity(categoryDto));
    }

    @Override
    public void deleteCategory(UUID id) {
        log.info("Delete Category with id = " + id);
        categoryRepository.deleteById(id);
    }
}
