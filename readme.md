# Employee Maintenance System

## Employee Login Service
- Perform Login
- Perform Forget Password
- Add a new User

#### Login Service Endpoints
- Perform Login
POST `/login`
```
{
  "username": "gagan",
  "password": "123456"
}
```
- Change Password
POST `/login/change`
```
{
  "empId": "100001",
  "password": "1234"
}
```
- Add a new User (Not used directly)
POST `/login/add`
```
{
  "username": "test",
  "password": "1234",
  "role": {
    "roleId": 100001
  }
}
```

## Employee Maintenance Service
- Add new Employee
- Edit Employee Details 
- Fetch Employee by categories

#### Employee Maintenance Endpoints

- Add Employees
POST `/employees`
```
{
  "username": "gagan",
  "password": "123456",
  "role": {
    "roleId": 100001,
    "role": "ROLE_ADMIN"
  },
  "employeeDetails": {
    "firstName": "Cem",
    "lastName": "Riggs",
    "dateOfBirth": "1991-08-30",
    "dateOfJoining": "2018-12-31",
    "email": "cem@mail.com",
    "phoneNumber": "7555361368",
    "maritalStatus": "Single",
    "gender": "M",
    "grade": "M2",
    "basic": 220000.0,
    "designation": "DataScientist",
    "department": {
      "departmentId": 100006,
      "departmentName": "Recreation"
    },
    "address": {
      "city": "CLEVELAND",
      "state": "Ohio",
      "area": "West Fork Drive",
      "pincode": "44113"
    },
    "manager": {
      "empDetailsId": 100006
    }
  }
}
```
- Fetch All Employees (Uses Paging with default values)
GET `/employees/search`
- Fetch with custom paging paramaters (pageNo, pageSize, sortBy)
GET `/employees/search?pageNo=1&pageSize=5&sortBy={employeeAttributeName}`
- Fetch By Categories - Gender (Multiple param seperated by ',')
GET `/employees/search/category?genders=M,F`
- Fetch By Categories - Grade (Multiple param seperated by ',')
GET `/employees/search/category?grades=M1,M7`
- Fetch By Categories - Department (Multiple param seperated by ',')
GET `/employees/search/category?departments={departmentId},{departmentId}`
- Fetch By Categories - Marital Status (Multiple param seperated by ',')
GET `/employees/search/category?maritalStatus=Single,Divorced`
- Fetch By Categories - Manager Id (Multiple param seperated by ',')
GET `/employees/search/category?managerId={managerId}`

## Leave Serice 
- Create leave
- Aproved By managers
- Fetch All Leaves of Employee (Uses paging)
- Fetch All leaves of Mnager's Sub employees (Uses paging)

#### Leave Endpoints 
- Fetch Employee Leaves
GET `/leaves/employee/{empId}`
- Fetch Sub Employee Leaves
GET `/leaves/manager/{managerId}`
- Fecth Leave Balance 
GET `/leaves/balance/{empId}`
- Create Leaves 
POST `/leaves`
```
{
      "leaveBalance": 13,
      "dateFrom": "2020-07-03",
      "dateTo": "2020-07-07",
      "leaveStatus": "Applied",
      "numberOfDays": 5,
      "employeeDetails": {
        "empDetailsId": 100006
      }
}
```
- Update Leaves (LeaveHistory object with leaveId, status)
PUT `/leaves`
```
{
  "leaveId": 100025,
  "leaveStatus": "Approved",
}
```

## Angular Front End (Employee-maintenance-frontend)

#### Routes to different components

Operation | Route
--------- | -----
Login          | `/login`
View Employees | `/employee/search`
Employee Info  | `/employee/home`
Leave          | `/employee/leaves`
Leave Details  | `/employee/addleave`
Change password| `/employee/change`
Admin add      | `/admin/add`
Admin edit     | `/admin/edit`
Manager approve| `/manager/approve`
Access Denied  | `/error/403`
Error          | `/error/404`
