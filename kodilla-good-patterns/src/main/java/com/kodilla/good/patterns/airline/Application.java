package com.kodilla.good.patterns.airline;

public class Application {
    public static void main(String[] args) {
        RoutesDataBase flightDataBase = new RoutesDataBase();
        CustomerDataBase customerDataBase = new CustomerDataBase();
        Customer customer = customerDataBase.getCustomer();
        Search search = new Search(flightDataBase);

        SearchResultDto resultsFrom = search.searchFlightsFrom(customer,"KRAKOW");
        System.out.println(resultsFrom);

        SearchResultDto resultsTo = search.searchFlightsTo(customer, "bytom");
        System.out.println(resultsTo);

        SearchResultDto resultsVia = search.searchFlightsVia(customer, "GDANSK", "KRAKOW",
                "WARSZAWA");
        System.out.println(resultsVia);
    }
}