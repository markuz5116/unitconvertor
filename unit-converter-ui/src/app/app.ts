import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { UnitConverterPage } from "./unit-converter-page/unit-converter-page";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, UnitConverterPage],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('unit-converter-ui');
}
