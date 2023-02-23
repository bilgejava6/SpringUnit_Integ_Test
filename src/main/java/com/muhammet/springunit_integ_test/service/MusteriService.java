package com.muhammet.springunit_integ_test.service;

import com.muhammet.springunit_integ_test.repository.IMusteriRepository;
import com.muhammet.springunit_integ_test.repository.entity.Musteri;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MusteriService {
    private final IMusteriRepository repository;

    public Musteri save(String ad,String adres, String telefon){
      if(repository.findAll().stream().filter(x-> x.getAd().equals(ad)).count()>0)
            throw new IllegalArgumentException("Böyle bir müşteri zaten var");
      Musteri musteri = repository.save(Musteri.builder()
              .ad(ad)
              .adres(adres)
              .telefon(telefon)
              .build());
      return  musteri;
    }

}
