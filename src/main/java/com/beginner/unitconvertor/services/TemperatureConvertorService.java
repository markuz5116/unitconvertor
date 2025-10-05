package com.beginner.unitconvertor.services;

import org.springframework.stereotype.Service;

import com.beginner.unitconvertor.dataTypes.TemperatureType;

@Service
public class TemperatureConvertorService implements UnitConvertorService {

  @Override
  public Double getConvertedAmount(String fromType, String toType, Double amount) {
    TemperatureType fromTemperatureType = getTemperatureTypeEnum(fromType.toUpperCase());
    TemperatureType toTemperatureType = getTemperatureTypeEnum(toType.toUpperCase());
    Double baseAmount = toBaseAmount(fromTemperatureType, amount);
    return convertAmountFromBase(toTemperatureType, baseAmount);
  }

  private TemperatureType getTemperatureTypeEnum(String type) {
    try {
      return TemperatureType.valueOf(type);
    } catch (IllegalArgumentException e) {
      throw new UnknownUnitTypeException(type);
    }
  }

  private Double convertAmountFromBase(TemperatureType toTemperatureType, Double amount) {
    switch (toTemperatureType) {
      case CELSIUS:
        return amount - toTemperatureType.conersionConstant;

      case FAHRENHEIT:
        return (9.0 / 5.0) * amount - toTemperatureType.conersionConstant;

      case KELVIN:
      default:
        break;
    }
    return amount;
  }

  private Double toBaseAmount(TemperatureType fromTemperatureType, Double amount) {
    switch (fromTemperatureType) {
      case CELSIUS:
        return amount + fromTemperatureType.conersionConstant;

      case FAHRENHEIT:
        return (5.0 / 9.0) * (amount + fromTemperatureType.conersionConstant);

      case KELVIN:
      default:
        break;
    }
    return amount;
  }

}
