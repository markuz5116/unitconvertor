import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { UnitAndSymbol } from '../data-models/UnitAndSymbol';

@Injectable({
  providedIn: 'root'
})
export class Converter {
  private httpClient = inject(HttpClient);
  readonly BASE_URL = "http://localhost:8080";

  getAllUnits(measurementType: string) {
    return this.httpClient.get<UnitAndSymbol[]>(`${this.BASE_URL}/units/${measurementType}`)
  }

  convert(measurementType: string, fromUnit: string, toUnit: string, amount: number) {
    // ?fromType=${fromUnit}&toType=${toUnit}&amount={${amount}
    return this.httpClient.get<number>(`${this.BASE_URL}/${measurementType}`, {
      params: {
        'fromType': fromUnit,
        'toType': toUnit,
        'amount': amount
      },
      timeout: 5000
    });
  }
}
