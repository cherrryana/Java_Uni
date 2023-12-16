package com.example.unitconverter.coverters.volume;

import com.example.unitconverter.coverters.BaseUnitConverter;
import com.example.unitconverter.coverters.UnitTypeConverter;
import com.example.unitconverter.coverters.length.FootConverter;
import com.example.unitconverter.coverters.length.MeterConverter;

import java.util.HashMap;

public class VolumeConverter extends UnitTypeConverter {

    private static BaseUnitConverter liiterConverter = new LiterConverter();
    private static BaseUnitConverter gallonConverter = new GallonConverter();

    public VolumeConverter() {
        super("Liter", new HashMap<String, BaseUnitConverter>() {
            {
                put(liiterConverter .getName(), liiterConverter );
                put(gallonConverter.getName(), gallonConverter);
            }
        });
    }

    @Override
    public String getUnitType() {
        return "Volume";
    }
}
