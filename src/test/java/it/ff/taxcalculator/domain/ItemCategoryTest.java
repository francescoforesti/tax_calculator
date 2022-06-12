package it.ff.taxcalculator.domain;

import it.ff.taxcalculator.fixtures.TestDomain;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class ItemCategoryTest {

    @Test
    void findTaxRate() {
        Item standardItem = TestDomain.createItem(1, BigDecimal.ONE, "", null);
        assertEquals(ItemCategory.DEFAULT.taxRate, ItemCategory.findTaxRate(standardItem));

        Item foodItem = TestDomain.createItem(1, BigDecimal.ONE, "", ItemCategory.FOOD);
        assertEquals(ItemCategory.FOOD.taxRate, ItemCategory.findTaxRate(foodItem));

        Item bookItem = TestDomain.createItem(1, BigDecimal.ONE, "", ItemCategory.BOOKS);
        assertEquals(ItemCategory.BOOKS.taxRate, ItemCategory.findTaxRate(bookItem));

        Item pillsItem = TestDomain.createItem(1, BigDecimal.ONE, "", ItemCategory.MEDICAL);
        assertEquals(ItemCategory.MEDICAL.taxRate, ItemCategory.findTaxRate(pillsItem));
    }

}
