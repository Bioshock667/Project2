import { TestBed } from '@angular/core/testing';

import { ServletHttpService } from './servlet-http.service';

describe('ServletHttpService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ServletHttpService = TestBed.get(ServletHttpService);
    expect(service).toBeTruthy();
  });
});
