import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageMarcaComponent } from './manage-marca.component';

describe('ManageMarcaComponent', () => {
  let component: ManageMarcaComponent;
  let fixture: ComponentFixture<ManageMarcaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ManageMarcaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ManageMarcaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
