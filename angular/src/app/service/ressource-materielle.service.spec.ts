import { TestBed } from '@angular/core/testing';

import { RessourceMaterielleService } from './ressource-materielle.service';

describe('RessourceMaterielleService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RessourceMaterielleService = TestBed.get(RessourceMaterielleService);
    expect(service).toBeTruthy();
  });
});
