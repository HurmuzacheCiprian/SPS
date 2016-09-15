package com.hurmuzache.sps.service;

import com.hurmuzache.sps.util.CatalogueDto;
import com.hurmuzache.sps.util.Category;
import com.hurmuzache.sps.util.Location;
import com.hurmuzache.sps.util.ProductDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CatalogueService {

    private final List<String> defaultProducts = Arrays.asList("Sky News", "Sky Sports News");


    public CatalogueDto getCatalogue(String locationId) {
        Location location = Location.getLocationByIdentifier(locationId);
        return CatalogueDto.builder().catalogueOfProducts(getProductsForCategoryAndLocation(location)).build();
    }

    private List<ProductDto> getProductsForCategoryAndLocation(Location location) {
        List<ProductDto> products = new ArrayList<>();
        if (location == Location.UNKNOWN) {
            products.add(ProductDto.builder().categoryName(Category.NEWS.getName()).products(defaultProducts).build());
        } else {
            products.add(ProductDto.builder().categoryName(Category.NEWS.getName()).products(defaultProducts).build());
            products.add(ProductDto.builder().categoryName(Category.SPORTS.getName()).products(getSpecificLocationProducts(location)).build());
        }
        return products;
    }

    private List<String> getSpecificLocationProducts(Location location) {
        List<String> specificLocationProducts = new ArrayList<>();
        switch (location) {
            case LONDON:
                specificLocationProducts.add("Arsenal TV");
                specificLocationProducts.add("Chelsea TV");
                break;
            case LIVERPOOOL:
                specificLocationProducts.add("Liverpool TV");
                break;
        }
        return specificLocationProducts;
    }


}
