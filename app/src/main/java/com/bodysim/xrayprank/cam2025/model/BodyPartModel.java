package com.bodysim.xrayprank.cam2025.model;

public class BodyPartModel {
    private final String title;
    private final int imageResId;
    private final String description;

    public BodyPartModel(int imageResId, String title, String description) {
        this.title = title;
        this.imageResId = imageResId;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getDescription() {
        return description;
    }
}
