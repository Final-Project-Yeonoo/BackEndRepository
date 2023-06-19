package com.ynfinal.finalproject.inventory.storeHouse.entity;

import com.ynfinal.finalproject.organization.user.entity.Employees;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "store_house")
public class StoreHouse {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storehouseCode;

    @Column(length = 100)
    private String storehouseName;

    @Enumerated(EnumType.STRING)
    private StoreHouseType storehouseType;

    @Temporal(TemporalType.DATE)
    @Column(name = "storehouse_start_date")
    private Date storehouseStartDate;

    @Column(length = 200)
    private String storehouseAddr;

    @ManyToOne
    @JoinColumn(name = "EMP_NO", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Employees employees;

}
