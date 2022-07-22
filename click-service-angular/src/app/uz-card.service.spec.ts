import { TestBed } from '@angular/core/testing';

import { UzCardService } from './uz-card.service';

describe('UzCardService', () => {
  let service: UzCardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UzCardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
