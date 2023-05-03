//package Database;
//
//package database;
//
//import ModelServer.User;
//
//
//public class UserDAO {
//
//    private String firstName;
//    private String lastName;
//    private String username;
//    private String password;
//    private String phoneNumber;
//
//    public EmployeeDO(Employee employee) {
//        if (employee.getName() == null) {
//            throw new RuntimeException("Name cannot be null");
//        } else {
//            name = "'" + employee.getName() + "'";
//        }
//        if (employee.getWorkingNumber() == null) {
//            throw new RuntimeException("Working number cannot be null");
//        } else {
//            workingNumber = employee.getWorkingNumber().toString();
//        }
//        if (employee.getDob() == null) {
//            throw new RuntimeException("Date of birth cannot be null");
//        } else {
//            dob = "'" + employee.getDob() + "'";
//
//        }
//        if (employee.getPhoneNumber() == null) {
//            throw new RuntimeException("Phone number cannot be null");
//        } else {
//            phoneNumber = "'" + employee.getPhoneNumber() + "'";
//        }
//        if (employee.getGender() == null) {
//            throw new RuntimeException("Gender cannot be null");
//        } else {
//            gender = "'" + employee.getGender() + "'";
//        }
//        if (employee.getRole() == null) {
//            throw new RuntimeException("Role cannot be null");
//        } else {
//            if (employee.getRole().equals(EmployeeRole.HR)) {
//                role = "'HR'";
//            } else if (employee.getRole().equals(EmployeeRole.WORKER)) {
//                role = "'WORKER'";
//            } else if (employee.getRole().equals(EmployeeRole.MAIN_MANAGER)) {
//                role = "'MAIN MANAGER'";
//            } else if (employee.getRole().equals(EmployeeRole.PROJECT_MANAGER)) {
//                role = "'PROJECT MANAGER'";
//            } else {
//                throw new RuntimeException("Role is not valid");
//            }
//        }
//        if (employee.getEmail() == null) {
//            throw new RuntimeException("Email cannot be null");
//        } else {
//            email = "'" + employee.getEmail() + "'";
//        }
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public String getWorkingNumber() {
//        return workingNumber;
//    }
//
//    public String getDob() {
//        return dob;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//}