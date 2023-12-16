package com.example.unitconverter.coverters;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class UnitTypeConverter {
    private String standartBaseUnit;

    public Map<String, BaseUnitConverter> getBaseUnitConvertersMap() {
        return baseUnitConverters;
    }

    public List<BaseUnitConverter> getBaseUnitConvertersList() {
        return new ArrayList<BaseUnitConverter>(baseUnitConverters.values());
    }

    public abstract String getUnitType();
    private Map<String, BaseUnitConverter> baseUnitConverters = new HashMap<>();

    protected UnitTypeConverter(String standartBaseUnit,
                                Map<String, BaseUnitConverter> baseUnitConverters) {
        this.standartBaseUnit = standartBaseUnit;
        this.baseUnitConverters = baseUnitConverters;
    }

    public BigDecimal convert(BigDecimal value, BaseUnitConverter from, BaseUnitConverter to) {
        if (to.getName().equals((from.getName()))) {
            return value.setScale(4, RoundingMode.HALF_UP);
        }

        else if (from.getName().equals(standartBaseUnit)) {
            BigDecimal fromBase = baseUnitConverters.get(to.getName()).convertFromBase(value);
            return fromBase.setScale(4, RoundingMode.HALF_UP);
        }

        else {
            BigDecimal base = baseUnitConverters.get(from.getName()).convertToBase(value);

            if (to.getName().equals(standartBaseUnit)) {
                return base.setScale(4, RoundingMode.HALF_UP);
            }
            else {
                BigDecimal fromBase = baseUnitConverters.get(to.getName()).convertFromBase(base);
                return fromBase.setScale(4, RoundingMode.HALF_UP);
            }
        }
    }

}
