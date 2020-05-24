import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ApproveLeaveComponent } from './approve-leave.component';

describe('ApproveLeaveComponent', () => {
  let component: ApproveLeaveComponent;
  let fixture: ComponentFixture<ApproveLeaveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApproveLeaveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApproveLeaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
