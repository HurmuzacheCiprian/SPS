package com.hurmuzache.sps.resource;

import com.hurmuzache.sps.service.CatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/catalogue")
public class CatalogueResource {

    @Autowired
    private CatalogueService catalogueService;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity getProducts(@RequestParam(value = "locationID", required = false) String locationId) {
        return new ResponseEntity<>(catalogueService.getCatalogue(locationId), HttpStatus.OK);
    }

}
