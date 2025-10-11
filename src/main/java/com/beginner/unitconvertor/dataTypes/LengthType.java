package com.beginner.unitconvertor.dataTypes;

public enum LengthType {
  MILLIMETER(0.001, "mm"), CENTIMETER(0.01, "cm"), METER(1.0, "m"), KILOMETER(1000.0, "km"), INCH(0.0254, "in"),
  FOOT(0.3048, "ft"), YARD(0.9144, "yd"), MILE(1609.344, "mi");

  public final Double conversionAmountToBase;
  public final String symbol;

  LengthType(Double conversionAmountToBase, String symbol) {
    this.conversionAmountToBase = conversionAmountToBase;
    this.symbol = symbol;
  }
}
