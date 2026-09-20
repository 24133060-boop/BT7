package vn.iostar.service;
import vn.iostar.dto.CategoryDto;

import java.util.List;
import vn.iostar.dto.CategoryDto;

public interface CategoryService {
    List<CategoryDto> findAll();
    CategoryDto findById(Long id);
    void save(CategoryDto categoryDto);
    void deleteById(Long id);
}