package com.waracle.cakemgr.cakemanager.repository;

import com.waracle.cakemgr.cakemanager.entity.Cake;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CakeRepository extends CrudRepository<Cake, Long> {
    List<Cake> findByEmployeeId(int employeeId);
}
