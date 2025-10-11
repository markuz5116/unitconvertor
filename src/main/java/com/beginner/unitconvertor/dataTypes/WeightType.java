package com.beginner.unitconvertor.dataTypes;

public enum WeightType {
  MILLIGRAM(0.001, "mg"), GRAM(1.0, "g"), KILOGRAM(1000.0, "kg"), OUNCE(28.3495, "oz"), POUND(453.592, "lb");

  public final Double conversionAmount;
  public final String symbol;

  private WeightType(Double conversionAmount, String symbol) {
    this.conversionAmount = conversionAmount;
    this.symbol = symbol;
  }
}
