package vn.iostar.dto;

import org.springframework.web.multipart.MultipartFile;

public class ProductDto {
    private Long id;
    private String name;
    private Double price;
    private Integer quantity;
    private String description;
    private String images;
    private MultipartFile imageFile;
    private Long categoryId;

    public ProductDto() {}

    public ProductDto(Long id, String name, Double price, Integer quantity, String description, String images, MultipartFile imageFile, Long categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.images = images;
        this.imageFile = imageFile;
        this.categoryId = categoryId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImages() { return images; }
    public void setImages(String images) { this.images = images; }

    public MultipartFile getImageFile() { return imageFile; }
    public void setImageFile(MultipartFile imageFile) { this.imageFile = imageFile; }

    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }
}