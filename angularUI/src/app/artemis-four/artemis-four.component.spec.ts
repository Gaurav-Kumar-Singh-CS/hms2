import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArtemisFourComponent } from './artemis-four.component';

describe('ArtemisFourComponent', () => {
  let component: ArtemisFourComponent;
  let fixture: ComponentFixture<ArtemisFourComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ArtemisFourComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ArtemisFourComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  

});
