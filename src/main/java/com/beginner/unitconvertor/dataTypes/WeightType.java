package com.beginner.unitconvertor.dataTypes;

public enum WeightType {
  MILLIGRAM(0.001), GRAM(1.0), KILOGRAM(1000.0), OUNCE(28.3495), POUND(453.592);

  public final Double conversionAmount;

  private WeightType(Double conversionAmount) {
    this.conversionAmount = conversionAmount;
  }
}
