package com.hurmuzache.sps.service;

import com.hurmuzache.sps.util.CatalogueDto;
import com.hurmuzache.sps.util.Category;
import com.hurmuzache.sps.util.ProductDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CatalogueServiceTest {

    @Autowired
    private CatalogueService catalogueService;

    @Test
    public void shouldAlwaysGetOnlyTheNewsProductsWhenLocationIsInvalid() {
        CatalogueDto catalogue = catalogueService.getProducts("fake");
        checkDefaultCatalogueResponse(catalogue);
    }

    @Test
    public void shouldAlwaysReturnTheNewsListForInvalidLocation() {
        CatalogueDto catalogue = catalogueService.getProducts("");
        checkDefaultCatalogueResponse(catalogue);
    }

    @Test
    public void shouldAlwaysReturnTheNewsListForNullLocation() {
        CatalogueDto catalogue = catalogueService.getProducts(null);
        checkDefaultCatalogueResponse(catalogue);
    }

    @Test
    public void shouldGetListWithSportsAndNewsForLondonIdentifierLocation() {
        CatalogueDto catalogue = catalogueService.getProducts("London-Identifier");
        checkCatalogueResponse(catalogue);
        List<ProductDto> products = catalogue.getCatalogueOfProducts();
        Assert.isTrue(products.get(0).getProducts().size() == 2);
        List<String> productNames = products.get(1).getProducts();
        System.out.print(productNames);
        Assert.isTrue(productNames.size() == 2);
        Assert.isTrue(productNames.get(0).equals("Arsenal TV"));
        Assert.isTrue(productNames.get(1).equals("Chelsea TV"));
    }

    @Test
    public void shouldGetListWithSportsAndNewsForLiverpoolIdentifierLocation() {
        CatalogueDto catalogue = catalogueService.getProducts("Liverpool-Identifier");
        checkCatalogueResponse(catalogue);
        List<ProductDto> products = catalogue.getCatalogueOfProducts();
        Assert.isTrue(products.get(0).getProducts().size() == 2);
        List<String> productNames = products.get(1).getProducts();
        System.out.print(productNames);
        Assert.isTrue(productNames.size() == 1);
        Assert.isTrue(productNames.get(0).equals("Liverpool TV"));
    }

    private void checkDefaultCatalogueResponse(CatalogueDto catalogue) {
        List<ProductDto> products = catalogue.getCatalogueOfProducts();
        Assert.isTrue(products != null && products.size() == 1);
        Assert.isTrue(products.get(0) != null && products.get(0).getCategoryName().equals(Category.NEWS.getName()));
        Assert.isTrue(products.get(0).getProducts().size() == 2);
        Assert.isTrue(products.get(0).getProducts().get(0).equals("Sky News"));
        Assert.isTrue(products.get(0).getProducts().get(1).equals("Sky Sports News"));
    }

    private void checkCatalogueResponse(CatalogueDto catalogue) {
        List<ProductDto> products = catalogue.getCatalogueOfProducts();
        Assert.isTrue(products != null && products.size() == 2);
        Assert.isTrue(products.get(0) != null && products.get(0).getCategoryName().equals(Category.NEWS.getName()));
        Assert.isTrue(products.get(1) != null && products.get(1).getCategoryName().equals(Category.SPORTS.getName()));
    }
}
