package com.waracle.cakemgr.cakemanager.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cake {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID", unique = true, nullable = false)
    private Integer employeeId;

    @Column(name = "FIRST_NAME", unique = false, nullable = false, length = 100)
    private String firstName;

    @Column(name = "LAST_NAME", unique = false, nullable = false, length = 300)
    private String lastName;

    @Column(name = "EMAIL", unique = true, nullable = false, length = 100)
    private String email;
}