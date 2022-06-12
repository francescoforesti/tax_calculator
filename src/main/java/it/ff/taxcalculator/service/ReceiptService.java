package it.ff.taxcalculator.service;

import it.ff.taxcalculator.domain.Item;
import it.ff.taxcalculator.domain.ItemCategory;
import it.ff.taxcalculator.domain.Order;
import it.ff.taxcalculator.domain.Receipt;

public class ReceiptService {

    public Receipt calculateReceiptOf(Order cart) {
        return Receipt.from(cart, this::findTaxRateOf);
    }

    private Double findTaxRateOf(Item i) {
        return (double)
                ItemCategory.findTaxRate(i) +
                (Boolean.TRUE.equals(i.getImported()) ? 5 : 0);
    }

}
