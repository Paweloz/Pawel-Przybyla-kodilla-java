package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchingFacade {
    private final Logger companyLogger = LoggerFactory.getLogger(Company.class);
    private final Logger employeeLogger = LoggerFactory.getLogger(Employee.class);
    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;

    @Autowired
    public SearchingFacade(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public List<Company> findCompany(final String anyText) throws CompanySearchingException {
        companyLogger.info("Starting to search Company by : " + anyText);
        List<Company> companies = companyDao.findCompanyByAnyText(anyText);

        if (companies.size() == 0) {
            companyLogger.warn("Company not found");
            throw new CompanySearchingException(CompanySearchingException.ERR_COMPANY_NOT_FOUND);
        }
        return companies;
    }

    public List<Employee> findEmployee(final String anyText) throws EmployeeSearchingException {
        employeeLogger.info("Starting to search Employee by : " + anyText);
        List<Employee> employees = employeeDao.findEmployeeByAnyText(anyText);

        if(employees.size() == 0) {
            employeeLogger.warn("Employee not found");
            throw new EmployeeSearchingException(EmployeeSearchingException.ERR_EMPLOYEE_NOT_FOUND);
        }
        return employees;
    }
}
