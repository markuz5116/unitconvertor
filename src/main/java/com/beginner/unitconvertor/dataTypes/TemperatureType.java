package com.beginner.unitconvertor.dataTypes;

public enum TemperatureType {
  CELSIUS(273.15, "°C"), FAHRENHEIT(459.67, "°F"), KELVIN(0.0, "K");

  public final Double conersionConstant;
  public final String symbol;

  private TemperatureType(Double conersionConstant, String symbol) {
    this.conersionConstant = conersionConstant;
    this.symbol = symbol;
  }
}
