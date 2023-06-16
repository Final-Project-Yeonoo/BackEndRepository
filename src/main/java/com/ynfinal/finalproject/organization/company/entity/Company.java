package com.ynfinal.finalproject.organization.company.entity;

import lombok.*;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "MY_COMPANY")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long compCode;
    // 회사 이름
    @Column(nullable=false)
    private String compName;
    // 사업자 등록번호
    @Column(nullable=false)
    private String compRegNo;
    // 대표자 성명
    @Column(nullable=false)
    private String compCeo;
    // 전화번호
    private String compPhone;


    public void setCompCeo(String compCeo) {
        this.compCeo = compCeo;
    }
}
