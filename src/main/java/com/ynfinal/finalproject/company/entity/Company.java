package com.ynfinal.finalproject.company.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "my_company")
public class Company {

    @Id
    @Column(name ="comp_code")
    private String compCode;   // COM0001, COM0002, COM0003...
    // 회사 이름
    @Column(name = "comp_name")
    private String compName; // "중앙", "삼성", "여누", "LG"
    // 사업자 등록번호
    @Column(name = "comp_reg_no") // "774-88-01234"
    private String compRegNo;
    // 대표자 성명
    @Column(name = "comp_ceo") // "가나다"
    private String compCeo;
    // 전화번호
    @Column(name = "comp_phone") // "010-3333-3333"
    private String compPhone;
}
