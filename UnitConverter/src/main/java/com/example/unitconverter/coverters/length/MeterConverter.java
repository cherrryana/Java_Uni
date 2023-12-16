package com.example.unitconverter.coverters.length;

import com.example.unitconverter.coverters.BaseUnitConverter;

import java.math.BigDecimal;

public class MeterConverter extends BaseUnitConverter {

    public MeterConverter() {
        this.Multiplier = new BigDecimal(1);
    }

    @Override
    public String getName() {
        return "Meter";
    }
}
