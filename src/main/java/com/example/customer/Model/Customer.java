package com.example.customer.Model;


import lombok.*;
import org.springframework.data.annotation.Id;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    private String _id;
    @NotEmpty(message = "Name cannot be empty")
    @Size(max=64, min = 10, message = "Name must be between 10 and 64 characters")
    private String name;
    @NotEmpty(message = "Address cannot be empty")
    @NotNull(message = "Address cannot be null")
    @Size(min = 10, message = "Name must be between 10 and 64 characters")
    private String address;
    @NotEmpty(message = "Country cannot be empty")
    @NotNull(message = "Country cannot be null")
    private String country;
    @Valid
    private Contact contact;
}
