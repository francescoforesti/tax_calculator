package it.ff.taxcalculator.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

@Getter
@Setter
public class ReceiptItem {

    private Item item;
    private BigDecimal salesTaxes;
    private BigDecimal totalPrice;

    public String toString() {
        return String.format(Locale.ROOT, "%d%s%s: %.2f",
                item.getQuantity(),
                Boolean.TRUE.equals(item.getImported()) ? " imported " : " ",
                item.getName(),
                totalPrice);
    }

    public static ReceiptItem from(Item i, Double taxRate) {
        var result = new ReceiptItem();
        result.item = i;
        result.salesTaxes = calculateTaxes(i, taxRate);
        result.totalPrice = result.salesTaxes.add(i.totalPrice());
        return result;
    }

    static BigDecimal calculateTaxes(Item i, Double taxRate) {
        return i.totalPrice()
                .multiply(BigDecimal.valueOf(taxRate))
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_EVEN)
                .divide(BigDecimal.valueOf(5), RoundingMode.CEILING)
                .multiply(BigDecimal.valueOf(5));
    }

}
