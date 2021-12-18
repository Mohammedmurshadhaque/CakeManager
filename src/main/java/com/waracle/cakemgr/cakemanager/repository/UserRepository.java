package com.waracle.cakemgr.cakemanager.repository;

import com.waracle.cakemgr.cakemanager.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
   User findByUsername(String username);
}
