import { Component } from '@angular/core';
import { UnitConverterForm } from "../unit-converter-form/unit-converter-form";

@Component({
  selector: 'app-unit-converter-page',
  imports: [UnitConverterForm],
  templateUrl: './unit-converter-page.html',
  styleUrl: './unit-converter-page.css'
})
export class UnitConverterPage {
  readonly measurementTypes = ['Length', 'Weight', 'Temperature'];
  selectedMeasurementType = 'Length';

  updateSelectedMeasurementType(event: PointerEvent) {
    const newSelectedMeasurementType = (event.target as HTMLInputElement).value;
    this.selectedMeasurementType = newSelectedMeasurementType;
  }
}
