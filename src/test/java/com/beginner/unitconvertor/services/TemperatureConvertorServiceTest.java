package com.beginner.unitconvertor.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TemperatureConvertorServiceTest {
  private TemperatureConvertorService temperatureConvertorService;

  @BeforeEach
  void setUp() {
    temperatureConvertorService = new TemperatureConvertorService();
  }

  @Test
  void testGetConvertedAmountCelsius() {
    String baseTempStr = "kelvin";
    String celsiusStr = "CELSIUS";

    Double convertedKelvinZero = this.temperatureConvertorService.getConvertedAmount(celsiusStr, baseTempStr, 0.0);
    assertEquals(273.15, convertedKelvinZero);

    Double convertedKelvinNeg = this.temperatureConvertorService.getConvertedAmount(celsiusStr, baseTempStr, -1.0);
    assertEquals(272.15, convertedKelvinNeg);

    Double convertedKelvinPos = this.temperatureConvertorService.getConvertedAmount(celsiusStr, baseTempStr, 1.0);
    assertEquals(274.15, convertedKelvinPos);

    Double convertedCelsiusZero = this.temperatureConvertorService.getConvertedAmount(baseTempStr, celsiusStr, 0.0);
    assertEquals(-273.15, convertedCelsiusZero);

    Double convertedCelsiusNeg = this.temperatureConvertorService.getConvertedAmount(baseTempStr, celsiusStr, -1.0);
    assertEquals(-274.15, convertedCelsiusNeg);

    Double convertedCelsiusPos = this.temperatureConvertorService.getConvertedAmount(baseTempStr, celsiusStr, 1.0);
    assertEquals(-272.15, convertedCelsiusPos);
  }

  @Test
  void testGetConvertedAmountFahrenheit() {
    String baseTempStr = "kelvin";
    String fahrenheitStr = "Fahrenheit";

    Double convertedKelvinZero = this.temperatureConvertorService.getConvertedAmount(fahrenheitStr, baseTempStr, 0.0);
    assertEquals(255.372, convertedKelvinZero, 0.001);

    Double convertedKelvinNeg = this.temperatureConvertorService.getConvertedAmount(fahrenheitStr, baseTempStr, -1.0);
    assertEquals(254.817, convertedKelvinNeg, 0.001);

    Double convertedKelvinPos = this.temperatureConvertorService.getConvertedAmount(fahrenheitStr, baseTempStr, 1.0);
    assertEquals(255.928, convertedKelvinPos, 0.001);

    Double convertedFahrenheitZero = this.temperatureConvertorService.getConvertedAmount(baseTempStr, fahrenheitStr,
        0.0);
    assertEquals(-459.67, convertedFahrenheitZero, 0.001);

    Double convertedFahrenheitNeg = this.temperatureConvertorService.getConvertedAmount(baseTempStr, fahrenheitStr,
        -1.0);
    assertEquals(-461.47, convertedFahrenheitNeg, 0.001);

    Double convertedFahrenheitPos = this.temperatureConvertorService.getConvertedAmount(baseTempStr, fahrenheitStr,
        1.0);
    assertEquals(-457.87, convertedFahrenheitPos, 0.001);
  }
}
