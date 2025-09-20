package com.beginner.unitconvertor.dataTypes;

public enum TemperatureType {
  CELSIUS(273.15), FAHRENHEIT(459.67), KELVIN(0.0);

  public final Double conersionConstant;

  private TemperatureType(Double conersionConstant) {
    this.conersionConstant = conersionConstant;
  }
}
