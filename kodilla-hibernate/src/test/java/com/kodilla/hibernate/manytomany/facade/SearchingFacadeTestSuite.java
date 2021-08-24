package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class SearchingFacadeTestSuite {

    @Autowired
    private SearchingFacade searchingFacade;

    @Test
    void testSearchingFacadeForCompany() {
        //Given
        List<Company> companiesFound = new ArrayList<>();

        //When
        try {
            companiesFound = searchingFacade.findCompany("FO");
        }catch (CompanySearchingException e) {
            System.out.println("Exception handling " + e.getMessage());
        }

        //Then
        Assertions.assertEquals(1, companiesFound.size());
        Assertions.assertEquals("Ford", companiesFound.get(0).getName());
    }

    @Test
    void testSearchingFacadeForEmployee() {
        //Given
        List<Employee> employeesFound = new ArrayList<>();

        //When
        try {
            employeesFound = searchingFacade.findEmployee("Kowa");
        }catch (EmployeeSearchingException e) {
            System.out.println("Exception handling " + e.getMessage());
        }

        //Then
        Assertions.assertEquals(1, employeesFound.size());
        Assertions.assertEquals("Kowalski", employeesFound.get(0).getLastname());
    }

}