package com.snmi.domain;

import com.snmi.dto.AccountDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "account")
public class Account extends BaseEntity {

    @NotNull(message = "Account's first name is required")
    @Size(min = 3, max = 20, message = "First name length must be between 3 and 20 chars")
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "Account's last name is required")
    @Size(min = 3, max = 25, message = "Last name length must be between 3 and 25 chars")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "Account's email is required")
    @Size(min = 5, max = 320, message = "Email length must be between 5 and 320 chars")
    @Email(regexp = ".+@.+\\..+")
    @Column(name = "email", unique = true)
    private String email;

    @NotNull(message = "Account's date of birth is required")
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    public void updateAccount(String firstName, String lastName, String email, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }
}
