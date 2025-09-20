package com.beginner.unitconvertor.dataTypes;

public enum WeightType {
  MILLIGRAM(Math.pow(1.0, -6)), GRAM(0.001), KILOGRAM(1.0), OUNCE(0.0283495231), POUND(0.45359237);

  public final Double conversionAmount;

  private WeightType(Double conversionAmount) {
    this.conversionAmount = conversionAmount;
  }
}
