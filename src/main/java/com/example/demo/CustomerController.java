package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {

    public final List<Kunde> alleKunder = new ArrayList<>();

    @PostMapping("/store")
    public void lagreKunde(Kunde innKunde) {
        alleKunder.add(innKunde);
    }

    @GetMapping("/getAll")
    public List<Kunde> getAlleKunder() {
        return alleKunder;
    }

    @GetMapping("/kunde")
    public Kunde returKunde(Kunde innKunde) {
        return innKunde;
    }
}
