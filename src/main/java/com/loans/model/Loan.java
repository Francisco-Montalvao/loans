package com.loans.model;

import com.loans.enums.TypeLoan;


public record Loan(
        TypeLoan type,
        Integer interest_rate
) {
    public Loan(TypeLoan loan) {
        this(loan, loan.getInterest_rate());
    }
}
