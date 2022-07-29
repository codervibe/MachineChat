package com.chat.service.Impl;
/*
 * Created by Administrator on 2020/7/23  0023
 * DateTime:2020/07/23 15:28
 * Description:
 * Others:
 */


import com.chat.Utils.WeatherUtils;
import com.chat.service.WeatherService;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 */
@Service
public class WeatherServiceImpl implements WeatherService {
    @Override
    public String queryAsCityname(String Cityname) {
        String weatherInfo = WeatherUtils.getWeather(Cityname);
        return weatherInfo;
    }
}
