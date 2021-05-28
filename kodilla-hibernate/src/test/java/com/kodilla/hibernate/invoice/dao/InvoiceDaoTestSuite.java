package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave(){
        //Given
        Invoice invoice = new Invoice("1234");

        Product product1 = new Product("product1");
        Product product2 = new Product("product2");
        Product product3 = new Product("product3");

        Item item = new Item(product1, new BigDecimal("120"),3,new BigDecimal("360"));
        Item item2 = new Item(product2, new BigDecimal("20"),1,new BigDecimal("20"));
        Item item3 = new Item(product3, new BigDecimal("50"),2,new BigDecimal("100"));

        invoice.getItems().add(item);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);

        product1.getItems().add(item);
        product2.getItems().add(item2);
        product3.getItems().add(item3);

        item.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);

        //When
        invoiceDao.save(invoice);

        //Then
        Assertions.assertNotEquals(0,invoice.getId());

        //CleanUp
        invoiceDao.deleteById(invoice.getId());
    }
}
