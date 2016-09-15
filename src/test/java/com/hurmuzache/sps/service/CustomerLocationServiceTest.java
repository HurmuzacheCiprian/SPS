package com.hurmuzache.sps.service;

import com.hurmuzache.sps.exceptions.CustomerLocationServiceException;
import com.hurmuzache.sps.util.Location;
import com.hurmuzache.sps.util.LocationDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerLocationServiceTest {

    @Autowired
    private CustomerLocationService customerService;

    @Test
    public void shouldReturnLondonAsLocationIDIfCustomerIdEndsWithLO() {
        LocationDto locationId = customerService.getLocationId("test-customer1");
        Assert.assertTrue(locationId.getLocationId().equals(Location.LONDON.getName()));
    }

    @Test
    public void shouldReturnLiverpoolAsLocationIDIfCustomerIdEndsWithLi() {
        LocationDto locationId = customerService.getLocationId("test-customer2");
        Assert.assertTrue(locationId.getLocationId().equals(Location.LIVERPOOOL.getName()));
    }

    @Test(expected = CustomerLocationServiceException.class)
    public void shouldThrowCustomerLocationServiceExceptionIfCustomerIdIsNotValid() {
        customerService.getLocationId("fake");
    }

    @Test(expected = CustomerLocationServiceException.class)
    public void shouldThrowCustomerLocationServiceExceptionIfCustomerIdIsNull() {
        customerService.getLocationId(null);
    }

    @Test(expected = CustomerLocationServiceException.class)
    public void shouldThrowCustomerLocationServiceExceptionIfCustomerIdIsEmpty() {
        customerService.getLocationId("");
    }

    @Test(expected = CustomerLocationServiceException.class)
    public void shouldThrowExceptionIfTheCustomerIsNotRegisteredYet() {
        customerService.getLocationId("fake-customer-id-BU");
    }

}
