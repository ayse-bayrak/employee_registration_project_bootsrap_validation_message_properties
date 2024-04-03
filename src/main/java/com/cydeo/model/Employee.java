package com.cydeo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

//    @NotNull // Field should not be null
//    @NotEmpty // Field should not be null "", ""-> this is empty String field,
//    @NotBlank // Field should not be "     " blank, "    "-> this is blank, there is no letter, no digit,

//    @NotBlank is covering all of., @NotEmpty is covering @NotNull and itself
//    @NotNull -> @NotNull
//    @NotEmpty ->@NotNull + @NotEmpty
//    @NotBlank ->@NotNull + @NotEmpty + @NotBlank

   @NotBlank
   @Size(max=12, min=2)
    private String firstName;
    private String lastName;
    //Thymeleaf returns yyyy-MM-dd but LocalDate accepts mm-dd-yyyy

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    private String email;
    private String password;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zipCode;

}
