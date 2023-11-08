package com.lth.weather.service;

import com.lth.weather.Utils.ResData;
import com.lth.weather.entity.Address;


public interface AddressService {
    ResData getAddress();

    ResData delAddress(String id);

    ResData putAddress(Address address);

    ResData addAddress(Address address);
}
