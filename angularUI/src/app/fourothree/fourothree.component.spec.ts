import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FourothreeComponent } from './fourothree.component';

describe('FourothreeComponent', () => {
  let component: FourothreeComponent;
  let fixture: ComponentFixture<FourothreeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FourothreeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FourothreeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
