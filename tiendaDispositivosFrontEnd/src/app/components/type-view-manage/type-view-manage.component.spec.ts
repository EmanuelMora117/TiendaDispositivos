import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TypeViewManageComponent } from './type-view-manage.component';

describe('TypeViewManageComponent', () => {
  let component: TypeViewManageComponent;
  let fixture: ComponentFixture<TypeViewManageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TypeViewManageComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TypeViewManageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
