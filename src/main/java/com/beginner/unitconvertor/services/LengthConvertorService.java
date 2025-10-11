package com.beginner.unitconvertor.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.beginner.unitconvertor.dataTypes.LengthType;

@Service
public class LengthConvertorService implements UnitConvertorService {

  @Override
  public Double getConvertedAmount(String fromType, String toType, Double amount) {
    LengthType fromLengthType = getLengthTypeEnum(fromType.toUpperCase());
    LengthType toLengthType = getLengthTypeEnum(toType.toUpperCase());
    Double baseAmount = this.convert(fromLengthType, amount, true);
    return this.convert(toLengthType, baseAmount, false);
  }

  private LengthType getLengthTypeEnum(String type) {
    try {
      return LengthType.valueOf(type);
    } catch (IllegalArgumentException e) {
      throw new UnknownUnitTypeException(type);
    }
  }

  private Double convert(LengthType lengthType, Double amount, Boolean isToBase) {
    if (isToBase) {
      return amount * lengthType.conversionAmountToBase;
    }
    return amount / lengthType.conversionAmountToBase;
  }

  @Override
  public List<String> getUnits() {
    List<String> units = new ArrayList<>();
    for (LengthType lengthType : LengthType.values()) {
      String lengthTypeName = lengthType.name().toLowerCase();
      units.add(lengthTypeName);
    }
    return units;
  }
}
