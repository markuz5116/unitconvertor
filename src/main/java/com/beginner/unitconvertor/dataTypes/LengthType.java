package com.beginner.unitconvertor.dataTypes;

public enum LengthType {
  MILLIMETER(0.001), CENTIMETER(0.01), METER(1.0), KILOMETER(1000.0), INCH(0.0254), FOOT(0.3048), YARD(0.9144),
  MILE(1609.344);

  public final Double conversionAmountToBase;

  LengthType(Double conversionAmountToBase) {
    this.conversionAmountToBase = conversionAmountToBase;
  }
}
