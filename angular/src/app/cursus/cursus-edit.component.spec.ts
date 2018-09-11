import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CursusEditComponent } from './cursus-edit.component';

describe('CursusEditComponent', () => {
  let component: CursusEditComponent;
  let fixture: ComponentFixture<CursusEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CursusEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CursusEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
