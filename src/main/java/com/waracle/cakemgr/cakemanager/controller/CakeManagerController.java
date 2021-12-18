package com.waracle.cakemgr.cakemanager.controller;

import com.waracle.cakemgr.cakemanager.api.server.CakeManagerApi;
import com.waracle.cakemgr.cakemanager.api.server.model.Cake;
import com.waracle.cakemgr.cakemanager.service.CakeMangerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CakeManagerController implements CakeManagerApi {

   private final CakeMangerService cakeMangerService;

    @Override
    public ResponseEntity<List<Cake>> listCakes() {
        return new ResponseEntity(cakeMangerService.getAllCakes(), HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<List<Cake>> listCakesByEmployeeId(String employeeId) {
        return new ResponseEntity(cakeMangerService.getCakeByEmployeeId(employeeId), HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<Void> cakesPost( Cake cake) {
        cakeMangerService.addCake(cake);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
