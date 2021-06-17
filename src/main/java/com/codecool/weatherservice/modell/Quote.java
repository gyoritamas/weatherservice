package com.codecool.weatherservice.modell;

import com.codecool.weatherservice.WeatherCache;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quote {

    private String name;
    private Main main;

    @Override
    public String toString() {
        return "Város: "+getName()+","
                +" Hőmérséklet: "+getMain().getTemp()+"C,"
                +" Páratartalom: "+getMain().getHumidity()+"%";
    }
}
