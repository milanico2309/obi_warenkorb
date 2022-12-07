package com.example.obi_warenkorb.Artikel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtikelService {

    private final ArtikelRepository artikelRepository;

    @Autowired
    public ArtikelService(ArtikelRepository artikelRepository) {
        this.artikelRepository = artikelRepository;
    }

    /**
     * Returns a reference to an artikel with the given id, if there is an article with that id in the database.
     * @param id of the Artikel requested.
     * @return a refernce to an article or null if there is no article with the provided id the database.
     */
    public Artikel getArtikelbyID(Long id){
        return artikelRepository.findById(id).orElse(null);
    }

    public void substractAmount(Long id, int amount){
        Artikel artikel = getArtikelbyID(id);
        artikel.substractBestand(amount);
        artikelRepository.saveAndFlush(artikel);
    }

    public boolean isInStock(Long id, int amount){
        return getArtikelbyID(id).getBestand()>=amount;
    }

    public boolean isMinimumQty(Long id, int amount){
        return getArtikelbyID(id).getMindestanzahl()<=amount;
    }
}
