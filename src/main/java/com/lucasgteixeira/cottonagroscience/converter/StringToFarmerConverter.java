package com.lucasgteixeira.cottonagroscience.converter;

import com.lucasgteixeira.cottonagroscience.model.Farmer;
import com.lucasgteixeira.cottonagroscience.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToFarmerConverter implements Converter<String, Farmer> {

    private final FarmerService farmerService;

    @Autowired
    public StringToFarmerConverter(FarmerService farmerService) {
        this.farmerService = farmerService;
    }

    @Override
    public Farmer convert(String text) {
        if(text.isEmpty()){
            return null;
        }
        Long id =Long.valueOf(text);
        return farmerService.getFarmerById(id);
    }
}
