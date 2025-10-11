package com.beginner.unitconvertor.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.beginner.unitconvertor.dataTypes.WeightType;

@Service
public class WeightConvertorService implements UnitConvertorService {

  @Override
  public Double getConvertedAmount(String fromType, String toType, Double amount) {
    WeightType fromWeightType = getWeightTypeEnum(fromType.toUpperCase());
    WeightType toWeightType = getWeightTypeEnum(toType.toUpperCase());
    Double baseAmount = convertAmount(fromWeightType, amount, true);
    return convertAmount(toWeightType, baseAmount, false);
  }

  private WeightType getWeightTypeEnum(String type) {
    try {
      return WeightType.valueOf(type);
    } catch (IllegalArgumentException e) {
      throw new UnknownUnitTypeException(type);
    }
  }

  private Double convertAmount(WeightType weightType, Double amount, boolean isToBase) {
    if (isToBase) {
      return amount * weightType.conversionAmount;
    }
    return amount / weightType.conversionAmount;
  }

  @Override
  public List<String> getUnits() {
    List<String> units = new ArrayList<>();
    for (WeightType weightType : WeightType.values()) {
      units.add(weightType.name().toLowerCase());
    }
    return units;
  }

}
