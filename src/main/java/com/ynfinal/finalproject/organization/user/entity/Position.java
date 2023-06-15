package com.ynfinal.finalproject.organization.user.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "HR_POSITION")
public class Position {
    @Id
    private String posCode;
    @Column(nullable = false)
    private String posName;
}
