package com.example.obi_warenkorb.warenkorb;

import com.example.obi_warenkorb.Artikel.Artikel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@JsonSerialize(using = WarenkorbSerializer.class)
public class Warenkorb {

    private final Map<Artikel, Integer> items = new HashMap<>();

    public Map<Artikel, Integer> getItems() {
        return items;
    }



    public void putArtikel(Artikel item, Integer amount){
        items.merge(item, amount, Integer::sum);
    }

    public void removeArtikel(Artikel item){
        items.remove(item);
    }

    public void clear(){
        items.clear();
    }

    public BigDecimal getTotal() {
        return items
                .entrySet()
                .stream()
                .map(entry -> entry
                                .getKey()
                                .getCost()
                                .multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}

