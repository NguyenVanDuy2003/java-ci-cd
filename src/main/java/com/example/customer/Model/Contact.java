package com.example.customer.Model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Setter
@Getter
public class Contact {
    @NotEmpty(message = "Phone cannot be empty")
    @Pattern(regexp = "\\d+", message = "Phone should contain only numbers")
    @Size(min = 10, max = 11, message = "Phone must be between 10 and 11 characters")
    private String phone;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    private String email;
}
