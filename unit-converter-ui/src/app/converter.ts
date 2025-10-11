import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class Converter {
  getFromUnits(measurementType: string) {
    return ['f1', 'f2', 'f3'];
  }

  getToUnits(measurementType: string) {
    return ['t1', 't2', 't3'];
  }

  convert(measurementType: string, fromUnit: string, toUnit: string, amount: number) {
    return amount * -1;
  }
}
