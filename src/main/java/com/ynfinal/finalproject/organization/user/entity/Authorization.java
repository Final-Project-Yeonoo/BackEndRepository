package com.ynfinal.finalproject.organization.user.entity;


import com.ynfinal.finalproject.util.Check;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "authorization")
public class Authorization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authCode;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Check userAuth = Check.Y;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Check infoAuth = Check.Y;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Check salesAuth = Check.Y;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Check purchaseAuth = Check.Y;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Check inventoryAuth = Check.Y;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Check productAuth = Check.Y;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_no", nullable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Employees employees;





}
