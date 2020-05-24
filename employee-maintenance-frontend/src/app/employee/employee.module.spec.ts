import { EmployeeModule } from './employee.module';

describe('EmployeeModule', () => {
  let employeeModule: EmployeeModule;

  beforeEach(() => {
    employeeModule = new EmployeeModule();
  });

  it('should create an instance', () => {
    expect(employeeModule).toBeTruthy();
  });
});
