package it.ff.taxcalculator.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
public class Item {

    public Item(Integer quantity, BigDecimal unitPrice) {
        if(quantity == null || quantity < 1) {
            throw new IllegalArgumentException("invalid item quantity");
        }
        if(unitPrice == null || unitPrice.doubleValue() <= 0.0) {
            throw new IllegalArgumentException("invalid item price");
        }
        this.quantity = quantity;
        this.unitPrice = unitPrice.setScale(2, RoundingMode.UNNECESSARY);
    }

    private final Integer quantity;
    private final BigDecimal unitPrice;
    @Setter
    private String name = "unknown object";
    @Setter
    private ItemCategory category;
    @Setter
    private Boolean imported;

    BigDecimal totalPrice() {
        return BigDecimal
                .valueOf(quantity)
                .multiply(unitPrice);
    }

}
