package com.example.obi_warenkorb.warenkorb;

import com.example.obi_warenkorb.Artikel.Artikel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

public class WarenkorbSerializer extends StdSerializer<Warenkorb> {

    public WarenkorbSerializer(){
        this(null);
    }

    public WarenkorbSerializer(Class<Warenkorb> t) {
        super(t);
    }

    @Override
    public void serialize(Warenkorb warenkorb, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeStartObject();
        jsonGenerator.writeArrayFieldStart("items");

        //TODO: Create dedicated serializer for Artikel.Class
        for (Map.Entry<Artikel, Integer> item : warenkorb.getItems().entrySet()) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("itemName", item.getKey().getName());
            jsonGenerator.writeNumberField("cost", item.getKey().getCost());
            jsonGenerator.writeNumberField("amount", item.getValue());
            jsonGenerator.writeNumberField("costTotal", item
                    .getKey()
                    .getCost()
                    .multiply(BigDecimal.valueOf(item.getValue())));
            jsonGenerator.writeEndObject();
        }

        jsonGenerator.writeEndArray();
        jsonGenerator.writeNumberField("total", warenkorb.getTotal());
        jsonGenerator.writeEndObject();

    }
}
