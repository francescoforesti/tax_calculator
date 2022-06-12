package it.ff.taxcalculator.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Order {

    private List<Item> items = new ArrayList<>();

}
