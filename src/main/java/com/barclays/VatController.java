package com.barclays;

import com.barclays.client.VatRepository;
import com.barclays.client.model.Country;
import com.barclays.client.model.JsonVat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class VatController {


    @Autowired
    private VatRepository<JsonVat> vatClient;


    @RequestMapping("/all")
    List<Country> vatRates() {
        return vatClient.fetchJsonVat().getCountries();
    }

    @RequestMapping("/lowest")
    List<Country> lowest() {
       JsonVat jsonVat = vatClient.fetchJsonVat();
       return jsonVat.getCountries().stream().sorted(Comparator.comparing(country -> country.getNewestPeriod().getRate()
               .getStandard())).limit(3).collect(Collectors.toList());
    }

    @RequestMapping("/highest")
    List<Country> highest() {
        JsonVat jsonVat = vatClient.fetchJsonVat();
        return jsonVat.getCountries().stream().sorted(Comparator.comparing(country -> ((Country) country).getNewestPeriod().getRate()
                .getStandard()).reversed()).limit(3).collect(Collectors.toList());
    }
}
