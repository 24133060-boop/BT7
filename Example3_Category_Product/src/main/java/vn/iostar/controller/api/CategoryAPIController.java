package vn.iostar.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.tags.Tag;
import vn.iostar.dto.CategoryDto;
import vn.iostar.model.Response;
import vn.iostar.service.CategoryService;

@RestController
@RequestMapping("/api/category")
@Tag(name = "Category API", description = "Các API quản lý danh mục sản phẩm")
public class CategoryAPIController {

    @Autowired
    private CategoryService categoryService;

    // 1. Lấy tất cả Category
    @GetMapping
    public ResponseEntity<?> getAllCategory() {
        List<CategoryDto> list = categoryService.findAll();
        return new ResponseEntity<>(
            new Response(true, "Thành công", list), 
            HttpStatus.OK
        );
    }

    // 2. Lấy Category theo ID
    @PostMapping(path = "/getCategory")
    public ResponseEntity<?> getCategory(@Validated @RequestParam("id") Long id) {
        CategoryDto categoryDto = categoryService.findById(id);
        if (categoryDto != null) {
            return new ResponseEntity<>(
                new Response(true, "Thành công", categoryDto), 
                HttpStatus.OK
            );
        } else {
            return new ResponseEntity<>(
                new Response(false, "Thất bại", null), 
                HttpStatus.NOT_FOUND
            );
        }
    }

    // 3. Thêm mới Category
    @PostMapping(path = "/addCategory")
    public ResponseEntity<?> addCategory(
            @Validated @RequestParam("name") String name,
            @RequestParam(value = "file", required = false) MultipartFile file) {

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(name);
        categoryDto.setImageFile(file);

        categoryService.save(categoryDto);

        return new ResponseEntity<>(
            new Response(true, "Thêm thành công", categoryDto), 
            HttpStatus.OK
        );
    }

    // 4. Cập nhật Category
    @PutMapping(path = "/updateCategory")
    public ResponseEntity<?> updateCategory(
            @Validated @RequestParam("id") Long id,
            @Validated @RequestParam("name") String name,
            @RequestParam(value = "file", required = false) MultipartFile file) {

        CategoryDto categoryDto = categoryService.findById(id);
        if (categoryDto == null) {
            return new ResponseEntity<>(
                new Response(false, "Không tìm thấy Category", null), 
                HttpStatus.BAD_REQUEST
            );
        } else {
            categoryDto.setName(name);
            categoryDto.setImageFile(file);

            categoryService.save(categoryDto);

            return new ResponseEntity<>(
                new Response(true, "Cập nhật thành công", categoryDto), 
                HttpStatus.OK
            );
        }
    }

    // 5. Xóa Category
    @DeleteMapping(path = "/deleteCategory")
    public ResponseEntity<?> deleteCategory(@Validated @RequestParam("id") Long id) {
        CategoryDto categoryDto = categoryService.findById(id);
        if (categoryDto == null) {
            return new ResponseEntity<>(
                new Response(false, "Không tìm thấy Category", null), 
                HttpStatus.BAD_REQUEST
            );
        } else {
            categoryService.deleteById(id);
            return new ResponseEntity<>(
                new Response(true, "Xóa thành công", categoryDto), 
                HttpStatus.OK
            );
        }
    }
}