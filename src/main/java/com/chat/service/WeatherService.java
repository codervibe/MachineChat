package com.chat.service;

/*
 * Created by Administrator on 2020/7/23  0023
 * DateTime:2020/07/23 15:28
 * Description:
 * Others:
 */

import org.springframework.stereotype.Service;

/**
 * @author Administrator
 */
@Service("weatherService")

public interface WeatherService {
    public String queryAsCityname(String Cityname);
}
