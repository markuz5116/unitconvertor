import { Component, inject, input } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { Converter } from '../converter';

@Component({
  selector: 'app-unit-converter-form',
  imports: [ReactiveFormsModule, FormsModule],
  templateUrl: './unit-converter-form.html',
  styleUrl: './unit-converter-form.css'
})
export class UnitConverterForm {
  private converter = inject(Converter);

  measurementType = input<string>("");
  fromUnits = this.converter.getFromUnits(this.measurementType());
  toUnits = this.converter.getToUnits(this.measurementType());


  convertForm = new FormGroup({
    amount: new FormControl(0, Validators.required),
    fromUnit: new FormControl(this.fromUnits[0], Validators.required),
    toUnit: new FormControl(this.toUnits[0], Validators.required)
  })

  convert() {
    const amount = this.convertForm.value.amount;
    const fromUnit = this.convertForm.value.fromUnit;
    const toUnit = this.convertForm.value.toUnit;
    if (amount == null || fromUnit == null || toUnit == null) {
      throw new Error("Input cannot be null")
    }
    const convertedAmount = this.converter.convert(this.measurementType(), fromUnit, toUnit, amount)
    console.log(convertedAmount);
  }
}
