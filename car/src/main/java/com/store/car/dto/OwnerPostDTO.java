package com.store.car.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude
public class OwnerPostDTO {
    private String name;
    private String type;
    private String contactNumber;

}
