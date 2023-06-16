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

    //TODO ENUM 타입으로 바꿀것
    @Builder.Default
    private Check userAuth = Check.N;
    @Builder.Default
    private Check infoAuth = Check.N;
    @Builder.Default
    private Check salesAuth = Check.N;
    @Builder.Default
    private Check purchaseAuth = Check.N;
    @Builder.Default
    private Check inventoryAuth = Check.N;
    @Builder.Default
    private Check productAuth = Check.N;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_no", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Employees employees;



}
