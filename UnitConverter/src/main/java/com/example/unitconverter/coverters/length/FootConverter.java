package com.example.unitconverter.coverters.length;

import com.example.unitconverter.coverters.BaseUnitConverter;

import java.math.BigDecimal;

public class FootConverter extends BaseUnitConverter {

    public FootConverter() {
        this.Multiplier = new BigDecimal(0.3048);
    }

    @Override
    public String getName() {
        return "Foot";
    }
}
