package com.example.a16022706.c302_photo_storeii;

public class Details {
    private int photoId;
    private String title;
    private String description;
    private String image;
    private int categoryId;
    private String createdBy;

    public Details(int photoId, String title, String description, String image , int categoryId, String createdBy) {
        this.photoId= photoId;
        this.title = title;
        this.description = description;
        this.image = image;
        this.categoryId = categoryId;
        this.createdBy = createdBy;

    }
    public int getPhotoId() {
        return photoId;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getImage() {
        return image;
    }
    public int getCategoryId() {
        return categoryId;
    }
    public String getCreatedBy() {
        return createdBy;
    }



}
