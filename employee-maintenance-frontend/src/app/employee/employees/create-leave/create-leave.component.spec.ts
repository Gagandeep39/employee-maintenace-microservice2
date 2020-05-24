import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateLeaveComponent } from './create-leave.component';

describe('CreateLeaveComponent', () => {
  let component: CreateLeaveComponent;
  let fixture: ComponentFixture<CreateLeaveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateLeaveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateLeaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
