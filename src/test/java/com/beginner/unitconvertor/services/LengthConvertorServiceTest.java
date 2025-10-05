package com.beginner.unitconvertor.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LengthConvertorServiceTest {
  private LengthConvertorService lengthConvertorService;

  @BeforeEach
  void setUp() {
    this.lengthConvertorService = new LengthConvertorService();
  }

  @Test
  void testGetConvertedAmountToBaseMili() {
    String baseTypeString = "meter";
    String fromTypeString = "MILLIMETER";
    Double fromMiliToM0 = this.lengthConvertorService.getConvertedAmount(fromTypeString, baseTypeString, 0.0);
    assertEquals(0.0, fromMiliToM0);

    Double fromMiliPos = this.lengthConvertorService.getConvertedAmount(fromTypeString, baseTypeString, 1.0);
    assertEquals(0.001, fromMiliPos);

    Double fromMiliNeg = this.lengthConvertorService.getConvertedAmount(fromTypeString, baseTypeString, -1.0);
    assertEquals(-0.001, fromMiliNeg);
  }

  @Test
  void testGetConvertedAmountToBaseCenti() {
    String baseTypeString = "meter";
    String fromTypeString = "centimeter";
    Double fromCentiToM0 = this.lengthConvertorService.getConvertedAmount(fromTypeString, baseTypeString, 0.0);
    assertEquals(0.0, fromCentiToM0);

    Double fromCentiPos = this.lengthConvertorService.getConvertedAmount(fromTypeString, baseTypeString, 1.0);
    assertEquals(0.01, fromCentiPos);

    Double fromCentiNeg = this.lengthConvertorService.getConvertedAmount(fromTypeString, baseTypeString, -1.0);
    assertEquals(-0.01, fromCentiNeg);
  }

  @Test
  void testGetConvertedAmountToBaseKilo() {
    String baseTypeString = "meter";
    String fromTypeString = "KILOMETER";
    Double fromKiloToM0 = this.lengthConvertorService.getConvertedAmount(fromTypeString, baseTypeString, 0.0);
    assertEquals(0.0, fromKiloToM0);

    Double fromKiloPos = this.lengthConvertorService.getConvertedAmount(fromTypeString, baseTypeString, 1.0);
    assertEquals(1000, fromKiloPos);

    Double fromKiloNeg = this.lengthConvertorService.getConvertedAmount(fromTypeString, baseTypeString, -1.0);
    assertEquals(-1000, fromKiloNeg);
  }

  @Test
  void testGetConvertedAmountToBaseInch() {
    String baseTypeString = "meter";
    String fromTypeString = "Inch";
    Double fromInchToM0 = this.lengthConvertorService.getConvertedAmount(fromTypeString, baseTypeString, 0.0);
    assertEquals(0.0, fromInchToM0);

    Double fromInchPos = this.lengthConvertorService.getConvertedAmount(fromTypeString, baseTypeString, 1.0);
    assertEquals(0.0254, fromInchPos);

    Double fromInchNeg = this.lengthConvertorService.getConvertedAmount(fromTypeString, baseTypeString, -1.0);
    assertEquals(-0.0254, fromInchNeg);
  }

  @Test
  void testGetConvertedAmountToBaseFoot() {
    String baseTypeString = "meter";
    String fromTypeString = "fooT";
    Double fromFootToM0 = this.lengthConvertorService.getConvertedAmount(fromTypeString, baseTypeString, 0.0);
    assertEquals(0.0, fromFootToM0);

    Double fromFootPos = this.lengthConvertorService.getConvertedAmount(fromTypeString, baseTypeString, 1.0);
    assertEquals(0.3048, fromFootPos);

    Double fromFootNeg = this.lengthConvertorService.getConvertedAmount(fromTypeString, baseTypeString, -1.0);
    assertEquals(-0.3048, fromFootNeg);
  }

  @Test
  void testGetConvertedAmountToBaseYard() {
    String baseTypeString = "meter";
    String fromTypeString = "Yard";
    Double fromYardToM0 = this.lengthConvertorService.getConvertedAmount(fromTypeString, baseTypeString, 0.0);
    assertEquals(0.0, fromYardToM0);

    Double fromYardPos = this.lengthConvertorService.getConvertedAmount(fromTypeString, baseTypeString, 1.0);
    assertEquals(0.9144, fromYardPos);

    Double fromYardNeg = this.lengthConvertorService.getConvertedAmount(fromTypeString, baseTypeString, -1.0);
    assertEquals(-0.9144, fromYardNeg);
  }

  @Test
  void testGetConvertedAmountThrowUnknown() {
    assertThrows(UnknownUnitTypeException.class,
        () -> this.lengthConvertorService.getConvertedAmount("unknownFrom", "METER", 0.0));
  }
}
