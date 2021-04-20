import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArtemisTwoComponent } from './artemis-two.component';

describe('ArtemisTwoComponent', () => {
  let component: ArtemisTwoComponent;
  let fixture: ComponentFixture<ArtemisTwoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ArtemisTwoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ArtemisTwoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
