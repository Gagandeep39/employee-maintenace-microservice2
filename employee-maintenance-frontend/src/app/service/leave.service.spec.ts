import { TestBed } from '@angular/core/testing';

import { LeaveService } from './leave.service';

describe('LeaveService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LeaveService = TestBed.get(LeaveService);
    expect(service).toBeTruthy();
  });
});
