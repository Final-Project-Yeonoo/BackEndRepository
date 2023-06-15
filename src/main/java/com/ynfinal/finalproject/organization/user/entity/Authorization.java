package com.ynfinal.finalproject.organization.user.entity;


import com.sun.xml.bind.v2.TODO;
import com.ynfinal.finalproject.util.Check;
import lombok.*;

import javax.persistence.*;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "AUTHORIZATION")
public class Authorization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authCode;

    private Check userAuth = Check.N;
    private Check infoAuth = Check.N;
    private Check salesAuth = Check.N;
    private Check purchaseAuth = Check.N;
    private Check inventoryAuth = Check.N;
    private Check productAuth = Check.N;


    //    private Long empNo;


}
