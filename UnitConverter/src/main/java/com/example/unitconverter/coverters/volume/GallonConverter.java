package com.example.unitconverter.coverters.volume;

import com.example.unitconverter.coverters.BaseUnitConverter;

import java.math.BigDecimal;

public class GallonConverter extends BaseUnitConverter {

    public GallonConverter() {
        this.Multiplier = new BigDecimal(3.785);
    }

    @Override
    public String getName() {
        return "Gallon";
    }
}