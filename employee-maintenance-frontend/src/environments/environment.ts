// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  url: 'http://localhost:9900',
  login: '/employee-login-service/login',
  updateUser: '/employee-login-service/login/update',
  findUserById: '/employee-login-service/login/',
  changePassword: '/employee-login-service/login/change',

  addEmployee: '/employee-management-service/employees',
  fetchAllEmployee: '/employee-management-service/employees/search',
  searchByCategory: '/employee-management-service/employees/search/category',
  byName: '/employee-management-service/employees/search/name',
  byId: '/employee-management-service/employees/search/id/',

  employeeLeave: '/employee-leave-service/leaves/employee/',
  leaveBalance: '/employee-leave-service/leaves/balance/',
  subEmployeeLeaves: '/employee-leave-service/leaves/manager/',
  updateLeave: '/employee-leave-service/leaves/',
  createLeave: '/employee-leave-service/leaves/',

  grades: '/employee-validation-service/grades',
  departments: '/employee-validation-service/departments',
  managers: '/employee-validation-service/managers',
  roles: '/employee-validation-service/roles',
  validateUsername: '/employee-validation-service/username'
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
