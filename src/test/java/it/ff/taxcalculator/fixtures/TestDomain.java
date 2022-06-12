package it.ff.taxcalculator.fixtures;

import it.ff.taxcalculator.domain.Item;
import it.ff.taxcalculator.domain.ItemCategory;
import it.ff.taxcalculator.domain.Order;

import java.math.BigDecimal;
import java.util.List;

public class TestDomain {

    public static Item createItem(Integer quantity, BigDecimal unitPrice, String name, ItemCategory category) {
        var item = new Item(quantity, unitPrice);
        item.setCategory(category);
        item.setName(name);
        return item;
    }

    public static Item createImportedItem(Integer quantity, BigDecimal unitPrice, String name, ItemCategory category) {
        var item = createItem(quantity, unitPrice, name, category);
        item.setImported(true);
        return item;
    }

    /**
     * 1 book at 12.49
     * 1 music CD at 14.99
     * 1 chocolate bar at 0.85
     */
    public static Order createOrder1() {
        return createOrder(List.of(
                TestDomain.createItem(1, BigDecimal.valueOf(12.49), "book", ItemCategory.BOOKS),
                TestDomain.createItem(1, BigDecimal.valueOf(14.99), "music CD", null),
                TestDomain.createItem(1, BigDecimal.valueOf(0.85), "chocolate bar", ItemCategory.BOOKS)
        ));
    }

    /**
     * 1 imported box of chocolates at 10.00
     * 1 imported bottle of perfume at 47.50
     */
    public static Order createOrder2() {
        return createOrder(List.of(
                TestDomain.createImportedItem(1, BigDecimal.valueOf(10.00), "box of chocolates", ItemCategory.FOOD),
                TestDomain.createImportedItem(1, BigDecimal.valueOf(47.50), "bottle of perfume", null)
        ));
    }

    /**
     * 1 imported bottle of perfume at 27.99
     * 1 bottle of perfume at 18.99
     * 1 packet of headache pills at 9.75
     * 1 imported box of chocolates at 11.25
     */
    public static Order createOrder3() {
        return createOrder(List.of(
                TestDomain.createImportedItem(1, BigDecimal.valueOf(27.99), "bottle of perfume", null),
                TestDomain.createItem(1, BigDecimal.valueOf(18.99), "bottle of perfume", null),
                TestDomain.createItem(1, BigDecimal.valueOf(9.75), "packet of headache pills", ItemCategory.MEDICAL),
                TestDomain.createImportedItem(1, BigDecimal.valueOf(11.25), "box of chocolates", ItemCategory.BOOKS)
        ));

    }

    public static Order createOrder(List<Item> items) {
        Order order = new Order();
        order.setItems(items);
        return order;
    }
}
