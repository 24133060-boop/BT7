package vn.iostar.service.impl;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iostar.dto.ProductDto;
import vn.iostar.entity.Category;
import vn.iostar.entity.Product;
import vn.iostar.mapper.ProductMapper;
import vn.iostar.repository.CategoryRepository;
import vn.iostar.repository.ProductRepository;
import vn.iostar.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<ProductDto> findAll() {
        return productRepository.findAll().stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto findById(Long id) {
        return productRepository.findById(id)
                .map(ProductMapper::toDto)
                .orElse(null);
    }

    @Override
    public void save(ProductDto productDto) {
        Product product = ProductMapper.toEntity(productDto);

        if (productDto.getCategoryId() != null) {
            Category category = categoryRepository.findById(productDto.getCategoryId()).orElse(null);
            product.setCategory(category);
        }

        if (productDto.getImageFile() != null && !productDto.getImageFile().isEmpty()) {
            try {
                String fileName = UUID.randomUUID().toString() + "_" + productDto.getImageFile().getOriginalFilename();
                String uploadDir = Paths.get("uploads/products").toFile().getAbsolutePath();
                
                File dir = new File(uploadDir);
                if (!dir.exists()) dir.mkdirs();

                File dest = new File(uploadDir + File.separator + fileName);
                productDto.getImageFile().transferTo(dest);
                product.setImages(fileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (productDto.getId() != null) {
            Product oldProduct = productRepository.findById(productDto.getId()).orElse(null);
            if (oldProduct != null) {
                product.setImages(oldProduct.getImages());
            }
        }

        productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}