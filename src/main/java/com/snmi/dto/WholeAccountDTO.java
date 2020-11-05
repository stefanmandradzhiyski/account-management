package com.snmi.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "The class represents a whole account's (includes id) object")
public class WholeAccountDTO extends AccountDTO {

    @ApiModelProperty(notes = "Account's unique identifier", example = "1")
    private Long id;

}
