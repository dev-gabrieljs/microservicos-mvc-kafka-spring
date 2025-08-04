package com.portal.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude
@Getter
@Setter
public class OwnerPostDTO {
    private String name;
    private String type;
    private String contactNumber;

}
