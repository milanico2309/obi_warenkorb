package com.example.obi_warenkorb.warenkorb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api/v1/warenkorb")
public class WarenkorbController {

    private final WarenkorbService warenkorbService;

    @Autowired
    public WarenkorbController(WarenkorbService warenkorbService) {
        this.warenkorbService = warenkorbService;
    }

    @GetMapping("/ping")
    public String hello() {
        return "Pong!";
    }

    @PutMapping("/addArtikel")
    public void addArtikelToWarenkorb(@RequestParam Long id,@RequestParam int amount){
        warenkorbService.addArtikel(id, amount);
    }

    @GetMapping("/getWarenkorb")
    public Warenkorb getWarenkorb(){
        return warenkorbService.getWarenkorb();
    }


    @DeleteMapping("/removeArtikel")
    public void removeArtikelFromWarenkorb(@RequestParam Long id){
        warenkorbService.removeArtikel(id);
    }

    /**
     * Deletes the specified Warenkorb
     * @return
     */
    @DeleteMapping("/clearWarenkorb")
    public void deleteWarenkorb(){
        warenkorbService.clear();
    }

}
