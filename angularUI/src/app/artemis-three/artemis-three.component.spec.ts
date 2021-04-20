import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArtemisThreeComponent } from './artemis-three.component';

describe('ArtemisThreeComponent', () => {
  let component: ArtemisThreeComponent;
  let fixture: ComponentFixture<ArtemisThreeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ArtemisThreeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ArtemisThreeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
