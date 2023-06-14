package com.ynfinal.finalproject.company.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "my_company")
public class Company {

    @Id
    String compCode;
    String compName;
    String compRegNo;
    String compCeo;
    String compPhone;


}
