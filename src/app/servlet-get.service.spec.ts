import { TestBed } from '@angular/core/testing';

import { ServletGetService } from './servlet-get.service';

describe('ServletGetService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ServletGetService = TestBed.get(ServletGetService);
    expect(service).toBeTruthy();
  });
});
