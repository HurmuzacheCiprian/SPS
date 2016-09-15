package com.hurmuzache.sps.resource;

import com.hurmuzache.sps.service.CustomerLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer-location")
public class CustomerLocationResource {

    @Autowired
    private CustomerLocationService customerLocationService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getCustomerLocation(@RequestParam("customerID") String customerId) {
        return new ResponseEntity<>(customerLocationService.getLocationId(customerId), HttpStatus.OK);
    }


}
