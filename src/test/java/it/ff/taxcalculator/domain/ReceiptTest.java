package it.ff.taxcalculator.domain;

import it.ff.taxcalculator.fixtures.TestDomain;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReceiptTest {

    @Test
    void testToString() {
        Order empty = TestDomain.createOrder(List.of());
        Receipt r = Receipt.from(empty, i -> 0.0);

        var expectedReceipt = "\nSales Taxes: 0.00\nTotal: 0.00";
        assertEquals(expectedReceipt, r.toString());

    }

}
