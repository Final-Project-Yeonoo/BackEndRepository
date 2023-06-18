package com.ynfinal.finalproject.organization.user.entity;


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
    private Long authCode;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Check userAuth = Check.N;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Check infoAuth = Check.N;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Check salesAuth = Check.N;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Check purchaseAuth = Check.N;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Check inventoryAuth = Check.N;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Check productAuth = Check.N;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_no", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Employees employees;





}
