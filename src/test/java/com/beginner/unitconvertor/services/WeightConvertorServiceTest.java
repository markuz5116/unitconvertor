package com.beginner.unitconvertor.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WeightConvertorServiceTest {
  private WeightConvertorService weightConvertorService;

  @BeforeEach
  void setUp() {
    this.weightConvertorService = new WeightConvertorService();
  }

  @Test
  void testGetConvertedAmountMilli() {
    String gramStr = "GRAM";
    String milligramStr = "milligram";

    Double convertedZero = this.weightConvertorService.getConvertedAmount(milligramStr, gramStr, 0.0);
    assertEquals(0, convertedZero);

    Double convertedNeg = this.weightConvertorService.getConvertedAmount(milligramStr, gramStr, -1.0);
    assertEquals(-0.001, convertedNeg);

    Double convertedPos = this.weightConvertorService.getConvertedAmount(milligramStr, gramStr, 1.0);
    assertEquals(0.001, convertedPos);
  }

  @Test
  void testGetConvertedAmountGram() {
    String gramStr = "GRAM";

    Double convertedZero = this.weightConvertorService.getConvertedAmount(gramStr, gramStr, 0.0);
    assertEquals(0, convertedZero);

    Double convertedNeg = this.weightConvertorService.getConvertedAmount(gramStr, gramStr, -1.0);
    assertEquals(-1, convertedNeg);

    Double convertedPos = this.weightConvertorService.getConvertedAmount(gramStr, gramStr, 1.0);
    assertEquals(1, convertedPos);
  }

  @Test
  void testGetConvertedAmountKilo() {
    String gramStr = "GRAM";
    String kilogramStr = "Kilogram";

    Double convertedZero = this.weightConvertorService.getConvertedAmount(kilogramStr, gramStr, 0.0);
    assertEquals(0, convertedZero);

    Double convertedNeg = this.weightConvertorService.getConvertedAmount(kilogramStr, gramStr, -1.0);
    assertEquals(-1000, convertedNeg);

    Double convertedPos = this.weightConvertorService.getConvertedAmount(kilogramStr, gramStr, 1.0);
    assertEquals(1000, convertedPos);
  }

  @Test
  void testGetConvertedAmountOunce() {
    String gramStr = "GRAM";
    String ouncegramStr = "Ouncegram";

    Double convertedZero = this.weightConvertorService.getConvertedAmount(ouncegramStr, gramStr, 0.0);
    assertEquals(0, convertedZero);

    Double convertedNeg = this.weightConvertorService.getConvertedAmount(ouncegramStr, gramStr, -1.0);
    assertEquals(-28.3495, convertedNeg);

    Double convertedPos = this.weightConvertorService.getConvertedAmount(ouncegramStr, gramStr, 1.0);
    assertEquals(28.3495, convertedPos);
  }

  @Test
  void testGetConvertedAmountPound() {
    String gramStr = "GRAM";
    String poundgramStr = "Poundgram";

    Double convertedZero = this.weightConvertorService.getConvertedAmount(poundgramStr, gramStr, 0.0);
    assertEquals(0, convertedZero);

    Double convertedNeg = this.weightConvertorService.getConvertedAmount(poundgramStr, gramStr, -1.0);
    assertEquals(-453.592, convertedNeg);

    Double convertedPos = this.weightConvertorService.getConvertedAmount(poundgramStr, gramStr, 1.0);
    assertEquals(453.592, convertedPos);
  }
}
