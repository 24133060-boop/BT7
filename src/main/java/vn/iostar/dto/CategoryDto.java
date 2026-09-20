package vn.iostar.dto;

import org.springframework.web.multipart.MultipartFile;

public class CategoryDto {
    private Long id;
    private String name;
    private String images;
    private MultipartFile imageFile;

    public CategoryDto() {}

    public CategoryDto(Long id, String name, String images, MultipartFile imageFile) {
        this.id = id;
        this.name = name;
        this.images = images;
        this.imageFile = imageFile;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getImages() { return images; }
    public void setImages(String images) { this.images = images; }

    public MultipartFile getImageFile() { return imageFile; }
    public void setImageFile(MultipartFile imageFile) { this.imageFile = imageFile; }
}