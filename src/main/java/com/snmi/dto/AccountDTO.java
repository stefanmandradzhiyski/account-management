package com.snmi.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.snmi.util.LocalDateHandler;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "The class represents an account's object")
public class AccountDTO {

    @NotNull(message = "Account's first name is required")
    @Size(min = 3, max = 20, message = "First name length must be between 3 and 20 chars")
    @ApiModelProperty(notes = "Account's first name", example = "Leon", required = true)
    private String firstName;

    @NotNull(message = "Account's last name is required")
    @Size(min = 3, max = 25, message = "Last name length must be between 3 and 25 chars")
    @ApiModelProperty(notes = "Account's last name", example = "Anderson", required = true)
    private String lastName;

    @NotNull(message = "Account's email is required")
    @Size(min = 5, max = 320, message = "Email length must be between 5 and 320 chars")
    @Email(regexp = ".+@.+\\..+")
    @ApiModelProperty(notes = "Account's email", example = "leon.anderson@gmail.com", required = true)
    private String email;

    @NotNull(message = "Account's date of birth is required")
    @ApiModelProperty(notes = "Account's birth date", example = "1994-06-08", required = true)
    @JsonDeserialize(using = LocalDateHandler.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateOfBirth;

}
