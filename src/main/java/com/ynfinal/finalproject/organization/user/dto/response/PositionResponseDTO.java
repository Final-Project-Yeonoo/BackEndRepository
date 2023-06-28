package com.ynfinal.finalproject.organization.user.dto.response;


import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PositionResponseDTO {
    private Long posCode;
    private String posName;
}
