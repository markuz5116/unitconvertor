import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UnitConverterPage } from './unit-converter-page';

describe('UnitConverterPage', () => {
  let component: UnitConverterPage;
  let fixture: ComponentFixture<UnitConverterPage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UnitConverterPage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UnitConverterPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
