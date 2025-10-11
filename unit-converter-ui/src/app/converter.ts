import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class Converter {
  private httpClient = inject(HttpClient);

  getFromUnits(measurementType: string) {
    return ['f1', 'f2', 'f3'];
  }

  getToUnits(measurementType: string) {
    return ['t1', 't2', 't3'];
  }

  convert(measurementType: string, fromUnit: string, toUnit: string, amount: number) {
    // ?fromType=${fromUnit}&toType=${toUnit}&amount={${amount}
    return this.httpClient.get<number>(`http://localhost:8080/${measurementType}`, {
      params: {
        'fromType': fromUnit,
        'toType': toUnit,
        'amount': amount
      },
      timeout: 5000
    });
  }
}
