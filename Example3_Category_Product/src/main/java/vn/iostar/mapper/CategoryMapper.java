package vn.iostar.mapper;

import vn.iostar.dto.CategoryDto;
import vn.iostar.entity.Category;

public class CategoryMapper {
    public static CategoryDto toDto(Category entity) {
        if (entity == null) return null;
        CategoryDto dto = new CategoryDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setImages(entity.getImages());
        return dto;
    }

    public static Category toEntity(CategoryDto dto) {
        if (dto == null) return null;
        Category entity = new Category();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setImages(dto.getImages());
        return entity;
    }
}