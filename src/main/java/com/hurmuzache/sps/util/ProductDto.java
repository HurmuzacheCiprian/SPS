package com.hurmuzache.sps.util;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String categoryName;
    private List<String> products;
}
