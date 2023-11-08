package com.lth.weather.controller;

import com.lth.weather.Utils.ResData;
import com.lth.weather.entity.Address;
import com.lth.weather.service.impl.AddressServiceImpl;
import com.lth.weather.service.impl.WeatherServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/weather")
@RestController
@RequiredArgsConstructor
public class WeatherController {
    private final static Logger log = LogManager.getLogger(WeatherController.class.getName());

    private final WeatherServiceImpl weatherService;
    private final AddressServiceImpl addressService;

    @GetMapping("/get")
    public ResData getWeatherData(@RequestParam(value = "cityName",required = false,defaultValue = "广州") String cityName) {
        log.info("查询天气,参数=>"+cityName);
        return weatherService.getWeatherData(cityName);
    }


//    查询所有地区
    @GetMapping("/getAddress")
    public ResData getAddress(){
        return addressService.getAddress();
    }

//    删除一个地区
    @DeleteMapping("/delAddress/{id}")
    public ResData delAddress(@PathVariable("id")String id){
        return addressService.delAddress(id);
    }

//    修改地区
    @PutMapping("/putAddress")
    public ResData putAddress(@RequestBody Address address){
        return addressService.putAddress(address);
    }

//    增加地区
    @PostMapping("/addAddress")
    public ResData addAddress(@RequestBody Address address){
        return addressService.addAddress(address);
    }
}
