package com.ynfinal.finalproject.manual.entity;

import com.ynfinal.finalproject.organization.company.entity.TradeCompany;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "returned")
public class Returned {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long returnedCode;
    @Enumerated(EnumType.STRING)
    private OrderType returnedStatus;
    @CreationTimestamp
    private Date returnedDate;
    private Long returnedReceipt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tr_comp_code", nullable = true, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private TradeCompany tradeCompany;
}
