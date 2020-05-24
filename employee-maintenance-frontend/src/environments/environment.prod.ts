export const environment = {
  production: true,
  url: 'http://139.59.72.125:9900',  // for docker
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