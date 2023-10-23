package com.store.library.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto {
    @Size(min = 3, max = 10, message = "3-10 ky tu")
    private String firstName;
    @Size(min = 3, max = 10, message = "3-10 ky tu")
    private String lastName;
    private String username;
    @Size(min = 5, max = 15, message = "5-15 ky tu")
    private String password;
    private String repeatPassword;
}
