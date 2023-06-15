package com.ynfinal.finalproject.organization.user.entity;


import com.sun.xml.bind.v2.TODO;
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
    //TODO ENUM 타입으로 바꿀것
    private boolean userAuth = false;
    private boolean infoAuth = false;
    private boolean salesAuth = false;
    private boolean purchaseAuth = false;
    private boolean inventoryAuth = false;
    private boolean productAuth = false;
//    private Long empNo;


}
