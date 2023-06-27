package com.ynfinal.finalproject.manual.entity;

import com.ynfinal.finalproject.inventory.products.entity.FinishedProduct;
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
@Table(name = "RETURN_DETAIL")
public class ReturnDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long returnDetailCode;
    @CreationTimestamp
    private Date returnDetailReceiptDate;
    private Long returnDetailQuantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "finished_code")
    private FinishedProduct finishedProduct;
}
