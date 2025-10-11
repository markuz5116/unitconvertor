import { Component, input } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-unit-converter-form',
  imports: [ReactiveFormsModule, FormsModule],
  templateUrl: './unit-converter-form.html',
  styleUrl: './unit-converter-form.css',
  standalone: true
})
export class UnitConverterForm {
  measurementType = input<string>("");
  fromUnits = ['1', '2', '3'];
  toUnits = ['3', '4', '5'];

  convertForm = new FormGroup({
    amount: new FormControl(0, Validators.required),
    fromUnit: new FormControl(this.fromUnits[0], Validators.required),
    toUnit: new FormControl(this.toUnits[0], Validators.required)
  })


  convert() {
    const amount = this.convertForm.value.amount;
    const fromUnit = this.convertForm.value.fromUnit;
    const toUnit = this.convertForm.value.toUnit;
  }
}
