package com.example.unitconverter.coverters.volume;

import com.example.unitconverter.coverters.BaseUnitConverter;

import java.math.BigDecimal;

public class LiterConverter extends BaseUnitConverter {

    public LiterConverter() {
        this.Multiplier = new BigDecimal(1);
    }

    @Override
    public String getName() {
        return "Liter";
    }
}
