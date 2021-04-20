import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArtemisOneComponent } from './artemis-one.component';

describe('ArtemisOneComponent', () => {
  let component: ArtemisOneComponent;
  let fixture: ComponentFixture<ArtemisOneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ArtemisOneComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ArtemisOneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
