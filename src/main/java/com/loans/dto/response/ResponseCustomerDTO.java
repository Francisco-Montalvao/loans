package com.loans.dto.response;

import com.loans.model.Loan;

import java.util.Set;

public record ResponseCustomerDTO (
        String customer,
        Set<Loan> loans

){

}
