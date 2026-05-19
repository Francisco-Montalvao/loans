package com.loans.controller;

import com.loans.LoansControllerApiDoc;
import com.loans.dto.request.RequestCustomerDTO;
import com.loans.dto.response.ResponseCustomerDTO;
import com.loans.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/customer-loans")
public class CustomerController implements LoansControllerApiDoc {

    private final LoanService service;

    public CustomerController(LoanService service) {
        this.service = service;

    }

    @Override
    public ResponseEntity<ResponseCustomerDTO> responseLoans(RequestCustomerDTO dto) {
        ResponseCustomerDTO response = service.loans(dto);
        return  ResponseEntity.ok(response);
    }
}
