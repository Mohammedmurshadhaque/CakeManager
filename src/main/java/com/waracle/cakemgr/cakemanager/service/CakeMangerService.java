package com.waracle.cakemgr.cakemanager.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.waracle.cakemgr.cakemanager.api.server.model.Cake;
import com.waracle.cakemgr.cakemanager.repository.CakeRepository;
import lombok.RequiredArgsConstructor;
import org.glassfish.jersey.internal.guava.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CakeMangerService {
    private final CakeRepository cakeRepository;

    public List<Cake> getAllCakes() {
        List<com.waracle.cakemgr.cakemanager.entity.Cake> cakeList = Lists.newArrayList(cakeRepository.findAll());
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(cakeList, new TypeReference<List<Cake>>() {});
    }

    public List<Cake> getCakeByEmployeeId(String employeeId) {
        List<com.waracle.cakemgr.cakemanager.entity.Cake> cakeList = cakeRepository.findByEmployeeId(Integer.valueOf(employeeId));
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(cakeList, new TypeReference<List<Cake>>() {});
    }

    public void addCake(Cake cake) {
        ObjectMapper objectMapper = new ObjectMapper();
        cakeRepository.save(objectMapper.convertValue(cake, com.waracle.cakemgr.cakemanager.entity.Cake.class));
    }
}
