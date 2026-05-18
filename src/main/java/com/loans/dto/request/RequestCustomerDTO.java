package com.loans.dto.request;

public record RequestCustomerDTO(
        Integer age,
        String cpf,
        String name,
        Double income,
        String location
) {
}
