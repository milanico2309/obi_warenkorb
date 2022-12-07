package com.example.obi_warenkorb.warenkorb;

import com.example.obi_warenkorb.Artikel.Artikel;
import com.example.obi_warenkorb.Artikel.ArtikelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarenkorbService {

    Warenkorb warenkorb = new Warenkorb();

    private final ArtikelService artikelService;

    @Autowired
    public WarenkorbService(ArtikelService artikelService) {
        this.artikelService = artikelService;
    }

    public Warenkorb getWarenkorb() {
        return warenkorb;
    }

    public void addArtikel(Long id, int amount){
        if(!artikelService.isMinimumQty(id, amount)) amount = artikelService.getArtikelbyID(id).getMindestanzahl();
        if(artikelService.isInStock(id, amount)){
            warenkorb.putArtikel(artikelService.getArtikelbyID(id), amount);
            artikelService.substractAmount(id, amount);
        }
    }

    public void removeArtikel(Long id) {
        warenkorb.removeArtikel(new Artikel(id));
    }

    public void clear() {
        warenkorb.clear();
    }
}
