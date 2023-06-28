package com.ynfinal.finalproject.organization.user.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "hr_position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long posCode;
    @Column(nullable = false)
    private String posName;
}
