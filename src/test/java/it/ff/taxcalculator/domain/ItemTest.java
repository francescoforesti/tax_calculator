package it.ff.taxcalculator.domain;

import it.ff.taxcalculator.fixtures.TestDomain;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {

    @Test
    void constructor() {
        assertThrows(IllegalArgumentException.class, () -> new Item(null, null));
        assertThrows(IllegalArgumentException.class, () -> new Item(1, null));
        assertThrows(IllegalArgumentException.class, () -> new Item(null, BigDecimal.ONE));
        assertThrows(IllegalArgumentException.class, () -> new Item(0, BigDecimal.ONE));
        assertThrows(IllegalArgumentException.class, () -> new Item(1, BigDecimal.ZERO));
    }

    @Test
    void totalPrice() {
        Item i1 = TestDomain.createItem(1, BigDecimal.valueOf(1.5), "rubber duck", null);
        assertEquals(BigDecimal.valueOf(1.50).setScale(2, RoundingMode.HALF_EVEN), i1.totalPrice());

        Item i2 = TestDomain.createItem(2, BigDecimal.valueOf(0.37), "free book", ItemCategory.BOOKS);
        assertEquals(BigDecimal.valueOf(0.74), i2.totalPrice());

        Item i3 = TestDomain.createImportedItem(3, BigDecimal.valueOf(10.5), "Havana Rhum", null);
        assertEquals(BigDecimal.valueOf(31.50).setScale(2, RoundingMode.HALF_EVEN), i3.totalPrice());
    }

}
