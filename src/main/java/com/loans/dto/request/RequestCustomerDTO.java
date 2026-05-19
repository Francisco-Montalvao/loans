package com.loans.dto.request;


import jakarta.validation.constraints.*;

public record RequestCustomerDTO(
        @NotNull(message = "age cannot be null")
        @Min(value = 18, message ="Age should not be less than 18")
        @Max(value = 100, message ="Age should not be greater than 100")
        Integer age,

        @NotNull(message = "cpf cannot be null")
        @Pattern(regexp = "(^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$)|(^\\d{11}$)", message = "Invalid CPF format")
        String cpf,

        @NotNull
        @Size(min=2, max=100)
        @NotBlank
        String name,

        @Positive
        @NotNull(message = "income cannot be null")
        Double income,

        @NotNull
        @NotBlank
        @Size(min = 2, max = 2)
        String location
) {
}
