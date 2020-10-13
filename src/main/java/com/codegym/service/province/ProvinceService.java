package com.codegym.service.province;

import com.codegym.model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import com.codegym.repository.ProvinceRepository;

public class ProvinceService implements IProvinceService{
    @Autowired
    ProvinceRepository provinceRepository;

    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Province findById(Long id) {
        return provinceRepository.findOne(id);
    }

    @Override
    public Province save(Province province) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
