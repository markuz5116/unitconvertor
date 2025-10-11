package com.beginner.unitconvertor.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Unknown unit type")
class UnknownUnitTypeException extends IllegalArgumentException {
  private final static String UNKNOWN_UNIT_TYPE_ERR_MSG = "Unknown unit type: %s";

  UnknownUnitTypeException(String unknownUnitType) {
    super(String.format(UNKNOWN_UNIT_TYPE_ERR_MSG, unknownUnitType));
  }
}

public interface UnitConvertorService {
  public Double getConvertedAmount(String fromType, String toType, Double amount);

  public List<String> getUnits();
}
