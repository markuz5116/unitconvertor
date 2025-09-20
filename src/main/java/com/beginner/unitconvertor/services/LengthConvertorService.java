package com.beginner.unitconvertor.services;

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
}
