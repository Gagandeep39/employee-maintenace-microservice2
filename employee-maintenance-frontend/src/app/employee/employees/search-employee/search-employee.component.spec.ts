import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchEmployeeComponent } from './search-employee.component';

describe('SearchEmployeeComponent', () => {
  let component: SearchEmployeeComponent;
  let fixture: ComponentFixture<SearchEmployeeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchEmployeeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchEmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
