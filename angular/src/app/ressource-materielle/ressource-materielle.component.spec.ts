import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RessourceMaterielleComponent } from './ressource-materielle.component';

describe('RessourceMaterielleComponent', () => {
  let component: RessourceMaterielleComponent;
  let fixture: ComponentFixture<RessourceMaterielleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RessourceMaterielleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RessourceMaterielleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
