package com.ynfinal.finalproject.organization.company.entity;

import lombok.*;
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
    private String compCode;   // 00000000, 10000000, 20000000...
    // 회사 이름
    @Column(nullable=false)
    private String compName; // "중앙", "삼성", "여누", "LG"
    // 사업자 등록번호
    @Column(nullable=false)// "774-88-01234"
    private String compRegNo;
    // 대표자 성명
    @Column(nullable=false)// "가나다"
    private String compCeo;
    // 전화번호
    private String compPhone; // "010-3333-3333"
}
