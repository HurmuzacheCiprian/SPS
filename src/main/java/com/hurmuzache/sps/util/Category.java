package com.hurmuzache.sps.util;

import lombok.Getter;

/**
 * Created by cipriach on 15.09.2016.
 */
@Getter
public enum Category {
    SPORTS("Sports"), NEWS("News");

    private String name;

    Category(String name) {
        this.name = name;
    }

    public static Category getCategoryByName(String name) {
        for (Category category : Category.values()) {
            if (category.getName().equals(name)) {
                return category;
            }
        }
        return null;
    }
}
