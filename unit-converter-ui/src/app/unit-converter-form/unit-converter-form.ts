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
  fromUnits: string[] = [];
  toUnits: string[] = [];

  showResultPage = false;
  convertedAmount = 0;
  convertForm = new FormGroup({
    amount: new FormControl(0, Validators.required),
    fromUnit: new FormControl(this.fromUnits[0], Validators.required),
    toUnit: new FormControl(this.toUnits[0], Validators.required)
  });

  ngOnInit() {
    this.converter.getAllUnits(this.measurementType()).subscribe({
      next: units => {
        this.toUnits = units;
        this.fromUnits = units;
      },
      error: err => {
        console.error(err);
      }
    })
  }

  convert() {
    const amount = this.convertForm.value.amount;
    const fromUnit = this.convertForm.value.fromUnit;
    const toUnit = this.convertForm.value.toUnit;
    if (amount == null || fromUnit == null || toUnit == null) {
      throw new Error("Input cannot be null")
    }
    this.converter.convert(this.measurementType(), fromUnit, toUnit, amount).subscribe({
      next: convertedAmount => {
        this.convertedAmount = convertedAmount;
        this.showResultPage = true;
      },
      error: err => {
        console.error(err);
        // TODO add error handling
      },
    });
  }

  resetPage() {
    this.convertForm.reset();
    this.convertedAmount = 0;
    this.showResultPage = false;
  }
}
