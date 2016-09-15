package com.hurmuzache.sps.util;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CatalogueDto {
    private List<ProductDto> catalogueOfProducts;
}
