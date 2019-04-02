package com.barclays.client.service;

import com.barclays.client.VatRepository;
import com.barclays.client.model.JsonVat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VatService implements VatRepository<JsonVat> {

    private static final Logger LOGGER = LoggerFactory.getLogger((VatService.class));


    @Override
    public JsonVat fetchJsonVat() {
        RestTemplate restTemplate = new RestTemplate();
        JsonVat vat = restTemplate.getForObject("http://jsonvat.com", JsonVat.class);
        return vat;
    }
}
