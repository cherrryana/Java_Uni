package com.example.unitconverter.coverters.length;

import com.example.unitconverter.coverters.BaseUnitConverter;
import com.example.unitconverter.coverters.UnitTypeConverter;

import java.util.HashMap;

public class LengthConverter extends UnitTypeConverter {

    private static BaseUnitConverter meterConverter = new MeterConverter();
    private static BaseUnitConverter footConverter = new FootConverter();

    public LengthConverter() {
        super("Meter", new HashMap<String, BaseUnitConverter>() {
            {
                put(meterConverter.getName(), meterConverter);
                put(footConverter.getName(), footConverter);
            }
        });
    }

    @Override
    public String getUnitType() {
        return "Length";
    }
}
