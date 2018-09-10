import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RessourceMaterielleEditComponent } from './ressource-materielle-edit.component';

describe('RessourceMaterielleEditComponent', () => {
  let component: RessourceMaterielleEditComponent;
  let fixture: ComponentFixture<RessourceMaterielleEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RessourceMaterielleEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RessourceMaterielleEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
