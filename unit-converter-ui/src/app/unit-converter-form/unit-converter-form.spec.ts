import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UnitConverterForm } from './unit-converter-form';

describe('UnitConverterForm', () => {
  let component: UnitConverterForm;
  let fixture: ComponentFixture<UnitConverterForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UnitConverterForm]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UnitConverterForm);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
