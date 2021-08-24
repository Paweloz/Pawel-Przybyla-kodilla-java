package com.kodilla.hibernate.manytomany.facade;

public class EmployeeSearchingException extends Exception {
    public final static String ERR_EMPLOYEE_NOT_FOUND = "Employee not found";

    public EmployeeSearchingException(String message) {
        super(message);
    }
}
