package vn.iostar.service.impl;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iostar.dto.CategoryDto;
import vn.iostar.entity.Category;
import vn.iostar.mapper.CategoryMapper;
import vn.iostar.repository.CategoryRepository;
import vn.iostar.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()	
                .map(CategoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto findById(Long id) {
        return categoryRepository.findById(id)
                .map(CategoryMapper::toDto)
                .orElse(null);
    }

    @Override
    public void save(CategoryDto categoryDto) {
        Category category = CategoryMapper.toEntity(categoryDto);

        if (categoryDto.getImageFile() != null && !categoryDto.getImageFile().isEmpty()) {
            try {
                String fileName = UUID.randomUUID().toString() + "_" + categoryDto.getImageFile().getOriginalFilename();
                String uploadDir = Paths.get("uploads").toFile().getAbsolutePath();
                File dest = new File(uploadDir + File.separator + fileName);
                categoryDto.getImageFile().transferTo(dest);
                category.setImages(fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        categoryRepository.save(category);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}