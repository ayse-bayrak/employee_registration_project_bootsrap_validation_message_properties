package com.cydeo.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

//    @NotNull // Field should not be null, you can use any kinf of object
//    @NotEmpty // Field should not be null "", ""-> this is empty String field, only use String
//    @NotBlank // Field should not be "     " blank, "    "-> this is blank, there is no letter, no digit, only use String

//    @NotBlank is covering all of., @NotEmpty is covering @NotNull and itself
//    @NotNull -> @NotNull
//    @NotEmpty ->@NotNull + @NotEmpty
//    @NotBlank ->@NotNull + @NotEmpty + @NotBlank

   @NotBlank
   @Size(max=12, min=2)
    private String firstName;
    private String lastName;
    //Thymeleaf returns yyyy-MM-dd but LocalDate accepts mm-dd-yyyy

// @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

//    @NotNull
//    @Email
    private String email;

//    @NotBlank
//    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,}")
    private String password;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zipCode;

}
