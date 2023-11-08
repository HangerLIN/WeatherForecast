package com.lth.weather.service.impl;

import com.lth.weather.Utils.ResData;
import com.lth.weather.entity.Address;
import com.lth.weather.mapper.AddressMapper;
import com.lth.weather.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;
    @Override
    public ResData getAddress() {
        List<Address> addresses = addressMapper.selectList(null);
        return ResData.resultObject(addresses);
    }

    @Override
    public ResData delAddress(String id) {
        int i = addressMapper.deleteById(id);
        return ResData.resultInt(i);
    }

    @Override
    public ResData putAddress(Address address) {
        int i = addressMapper.updateById(address);
        return ResData.resultInt(i);
    }

    @Override
    public ResData addAddress(Address address) {
        int insert = addressMapper.insert(address);
        return ResData.resultInt(insert);
    }
}
