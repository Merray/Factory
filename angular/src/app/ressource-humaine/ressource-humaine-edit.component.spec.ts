import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RessourceHumaineEditComponent } from './ressource-humaine-edit.component';

describe('RessourceHumaineEditComponent', () => {
  let component: RessourceHumaineEditComponent;
  let fixture: ComponentFixture<RessourceHumaineEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RessourceHumaineEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RessourceHumaineEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
