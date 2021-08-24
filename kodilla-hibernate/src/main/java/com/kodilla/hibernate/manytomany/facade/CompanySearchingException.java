package com.kodilla.hibernate.manytomany.facade;

public class CompanySearchingException extends Exception {
    public final static String ERR_COMPANY_NOT_FOUND = "Company not found";

    public CompanySearchingException(String message) {
        super(message);
    }
}
