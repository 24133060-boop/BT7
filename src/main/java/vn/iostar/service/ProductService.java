package vn.iostar.service;

import java.util.List;
import vn.iostar.dto.ProductDto;

public interface ProductService {
    List<ProductDto> findAll();
    ProductDto findById(Long id);
    void save(ProductDto productDto);
    void deleteById(Long id);
}