package it.ff.taxcalculator.domain;

import it.ff.taxcalculator.fixtures.TestDomain;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReceiptItemTest {

    @Test
    void testToString() {
        Item toothbrush = TestDomain.createItem(1, BigDecimal.valueOf(1.5), "Toothbrush", null);
        ReceiptItem toothbrushReceipt = ReceiptItem.from(toothbrush, 0.0);
        assertEquals("1 Toothbrush: 1.50", toothbrushReceipt.toString());

        Item importedWine = TestDomain.createImportedItem(2, BigDecimal.valueOf(10.5), "Bottle of Chilean wine", null);
        ReceiptItem importedWineReceipt = ReceiptItem.from(importedWine, 0.0);
        assertEquals("2 imported Bottle of Chilean wine: 21.00", importedWineReceipt.toString());
    }

    @Test
    void calculateTaxes() {
        Item importedPerfume = TestDomain.createImportedItem(1, BigDecimal.valueOf(47.5), "bottle of perfume", null);
        var actualTaxes = ReceiptItem.calculateTaxes(importedPerfume, 15.0);
        assertEquals(BigDecimal.valueOf(7.15), actualTaxes);

        Item cd = TestDomain.createImportedItem(1, BigDecimal.valueOf(14.99), "music CD", null);
        actualTaxes = ReceiptItem.calculateTaxes(cd, 10.0);
        assertEquals(BigDecimal.valueOf(1.5).setScale(2, RoundingMode.UNNECESSARY), actualTaxes);

        importedPerfume = TestDomain.createImportedItem(1, BigDecimal.valueOf(27.99), "bottle of perfume", null);
        actualTaxes = ReceiptItem.calculateTaxes(importedPerfume, 15.0);
        assertEquals(BigDecimal.valueOf(4.2).setScale(2, RoundingMode.UNNECESSARY), actualTaxes);
    }

}
