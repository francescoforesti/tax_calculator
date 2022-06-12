package it.ff.taxcalculator.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@Setter
public class Receipt {

    private List<ReceiptItem> items = new ArrayList<>();
    private BigDecimal taxes;
    private BigDecimal total;

    public String toString() {
        String itemList = items.stream()
                .map(ReceiptItem::toString)
                .collect(Collectors.joining("\n"));

        return String.format(Locale.ROOT, "%s\nSales Taxes: %.2f\nTotal: %.2f", itemList, taxes, total);
    }

    public static Receipt from(Order order, Function<Item, Double> taxRateFinder) {
        Receipt result = new Receipt();

        result.items = order.getItems().stream()
                .map(item -> ReceiptItem.from(item, taxRateFinder.apply(item)))
                .collect(Collectors.toList());

        result.taxes = result.items.stream()
                .map(ReceiptItem::getSalesTaxes)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        result.total = result.items.stream()
                .map(ReceiptItem::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return result;
    }
}
