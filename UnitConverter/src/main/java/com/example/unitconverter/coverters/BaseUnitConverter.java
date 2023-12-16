package com.example.unitconverter.coverters;
import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class BaseUnitConverter {
    protected BigDecimal Multiplier;

    public abstract String getName();

    public BigDecimal convertToBase(BigDecimal value) {
        return value.multiply(Multiplier).setScale(4, RoundingMode.HALF_UP);
    }

    public BigDecimal convertFromBase(BigDecimal value) {
        return value.divide(Multiplier, 4, RoundingMode.HALF_UP);
    }
}