package it.ff.taxcalculator.domain;

public enum ItemCategory {

    /**
     *  the tax rate information is hardcoded here.
     *  In a real-world scenario the item category could be used along with other information (e.g. the country)
     *  to retrieve the applicable tax rate from the persistence layer
    */

    DEFAULT(10),
    BOOKS(0),
    FOOD(0),
    MEDICAL(0);

    Integer taxRate;

    ItemCategory(int taxRate) {
        this.taxRate = taxRate;
    }

    public static Integer findTaxRate(Item item) {
        return item.getCategory() == null ? DEFAULT.taxRate : item.getCategory().taxRate;
    }
}
