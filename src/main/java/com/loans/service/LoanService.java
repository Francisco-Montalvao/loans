package com.loans.service;

import com.loans.dto.request.RequestCustomerDTO;
import com.loans.dto.response.ResponseCustomerDTO;
import com.loans.enums.TypeLoan;
import com.loans.model.Loan;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class LoanService {
    public ResponseCustomerDTO loans(RequestCustomerDTO customer) {
        var income = customer.income();
        var age = customer.age();
        var location = customer.location();

        Set<Loan> loanSet = new HashSet<>();

        if (income <= 3000.00) {
            loanSet.add(new Loan(TypeLoan.PERSONAL));
            loanSet.add(new Loan(TypeLoan.GUARANTEED));
        }

        if (income > 3000.0 && income < 5000.00 && age < 30 && location.equalsIgnoreCase("SP")) {
            loanSet.add(new Loan(TypeLoan.PERSONAL));
            loanSet.add(new Loan(TypeLoan.GUARANTEED));
        }

        if (income >= 5000.0) {
            loanSet.add(new Loan(TypeLoan.CONSIGNMENT));
        }
        return new ResponseCustomerDTO(customer.name(), loanSet);
    }


}
