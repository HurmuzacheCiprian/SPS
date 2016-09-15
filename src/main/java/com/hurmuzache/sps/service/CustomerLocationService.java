package com.hurmuzache.sps.service;

import com.hurmuzache.sps.exceptions.CustomerLocationServiceException;
import com.hurmuzache.sps.util.Location;
import com.hurmuzache.sps.util.LocationDto;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerLocationService {

    private final Map<String, Location> locations = new HashMap<>();

    @PostConstruct
    public void init() {
        locations.put("test-customer1", Location.LONDON);
        locations.put("test-customer2", Location.LIVERPOOOL);
    }

    public LocationDto getLocationId(String customerId) {
        Location location = locations.get(customerId);
        if (location == null) {
            throw new CustomerLocationServiceException("There was a problem retrieving the customer information");
        }
        return LocationDto.builder().locationId(location.getName()).build();
    }

}
