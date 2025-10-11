package com.beginner.unitconvertor.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.beginner.unitconvertor.dataTypes.MeasurementType;
import com.beginner.unitconvertor.dataTypes.UnitAndSymbol;
import com.beginner.unitconvertor.services.LengthConvertorService;
import com.beginner.unitconvertor.services.TemperatureConvertorService;
import com.beginner.unitconvertor.services.UnitConvertorService;
import com.beginner.unitconvertor.services.WeightConvertorService;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Unknown measurement type")
class UnknownMeasurementTypeException extends IllegalArgumentException {
  private static final String UNKNOWN_MEASUREMENT_TYPE_ERR_MSG = "Unknown measurement type: %s";

  UnknownMeasurementTypeException(String unknownMeasurementType) {
    super(String.format(UNKNOWN_MEASUREMENT_TYPE_ERR_MSG, UNKNOWN_MEASUREMENT_TYPE_ERR_MSG));
  }
}

@RestController
public class UnitConvertorController {
  private final LengthConvertorService lengthConvertorService;
  private final TemperatureConvertorService temparatureConvertorService;
  private final WeightConvertorService weightConvertorService;

  public UnitConvertorController(LengthConvertorService lengthConvertorService,
      TemperatureConvertorService temparatureConvertorService, WeightConvertorService weightConvertorService) {
    this.lengthConvertorService = lengthConvertorService;
    this.temparatureConvertorService = temparatureConvertorService;
    this.weightConvertorService = weightConvertorService;
  }

  @GetMapping("/units/{measurementType}")
  List<UnitAndSymbol> getUnits(@PathVariable String measurementType) {
    MeasurementType measurementTypeEnum = getMeasurementTypeEnum(measurementType);
    UnitConvertorService serviceToUse = getServiceToUse(measurementType, measurementTypeEnum);
    return serviceToUse.getUnits();
  }

  @GetMapping("/{measurementType}")
  Double getConvertedMeasurement(@PathVariable String measurementType, @RequestParam String fromType,
      @RequestParam String toType, @RequestParam Double amount) {
    MeasurementType measurementTypeEnum = getMeasurementTypeEnum(measurementType);
    UnitConvertorService serviceToUse = getServiceToUse(measurementType, measurementTypeEnum);
    return serviceToUse.getConvertedAmount(fromType, toType, amount);
  }

  private UnitConvertorService getServiceToUse(String measurementType, MeasurementType measurementTypeEnum) {
    UnitConvertorService serviceToUse = null;
    switch (measurementTypeEnum) {
      case LENGTH:
        serviceToUse = this.lengthConvertorService;
        break;
      case TEMPERATURE:
        serviceToUse = this.temparatureConvertorService;
        break;
      case WEIGHT:
        serviceToUse = this.weightConvertorService;
        break;

      default:
        throw new UnknownMeasurementTypeException(measurementType);
    }
    return serviceToUse;
  }

  private MeasurementType getMeasurementTypeEnum(String measurementType) {
    MeasurementType measurementTypeEnum = null;
    try {
      measurementTypeEnum = MeasurementType.valueOf(measurementType.toUpperCase());
    } catch (IllegalArgumentException e) {
      throw new UnknownMeasurementTypeException(measurementType);
    }
    return measurementTypeEnum;
  }
}
