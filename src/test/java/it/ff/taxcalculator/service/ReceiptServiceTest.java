package it.ff.taxcalculator.service;

import it.ff.taxcalculator.domain.Order;
import it.ff.taxcalculator.domain.Receipt;
import it.ff.taxcalculator.fixtures.TestDomain;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReceiptServiceTest {

    ReceiptService underTest = new ReceiptService();

    /**
     * Output 1:
     * 1 book: 12.49
     * 1 music CD: 16.49
     * 1 chocolate bar: 0.85
     * Sales Taxes: 1.50
     * Total: 29.83
     */
    @Test
    void testCalculateReceiptOfOrder1() {
        Order o1 = TestDomain.createOrder1();
        var expectedPrintedReceipt1 = "1 book: 12.49\n" +
                "1 music CD: 16.49\n" +
                "1 chocolate bar: 0.85\n" +
                "Sales Taxes: 1.50\n" +
                "Total: 29.83";
        Receipt receipt1 = underTest.calculateReceiptOf(o1);
        assertEquals(expectedPrintedReceipt1, receipt1.toString());
    }

    /**
     * Output 2:
     * 1 imported box of chocolates: 10.50
     * 1 imported bottle of perfume: 54.65
     * Sales Taxes: 7.65
     * Total: 65.15
     */
    @Test
    void testCalculateReceiptOfOrder2() {
        Order o2 = TestDomain.createOrder2();
        var expectedPrintedReceipt2 = "1 imported box of chocolates: 10.50\n" +
                "1 imported bottle of perfume: 54.65\n" +
                "Sales Taxes: 7.65\n" +
                "Total: 65.15";
        Receipt receipt2 = underTest.calculateReceiptOf(o2);
        assertEquals(expectedPrintedReceipt2, receipt2.toString());
    }

    /**
     * Output 3:
     * 1 imported bottle of perfume: 32.19
     * 1 bottle of perfume: 20.89
     * 1 packet of headache pills: 9.75
     * 1 imported box of chocolates: 11.85
     * Sales Taxes: 6.70
     * Total: 74.68
     */
    @Test
    void testCalculateReceiptOfOrder3() {
        Order o3 = TestDomain.createOrder3();
        var expectedPrintedReceipt3 = "1 imported bottle of perfume: 32.19\n" +
                        "1 bottle of perfume: 20.89\n" +
                        "1 packet of headache pills: 9.75\n" +
                        "1 imported box of chocolates: 11.85\n" +
                        "Sales Taxes: 6.70\n" +
                        "Total: 74.68";
        Receipt receipt3 = underTest.calculateReceiptOf(o3);
        assertEquals(expectedPrintedReceipt3, receipt3.toString());
    }

}
