package com.loans.controller;

import com.loans.dto.request.RequestCustomerDTO;
import com.loans.dto.response.ResponseCustomerDTO;
import com.loans.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController {

    private final LoanService service;

    public CustomerController(LoanService service) {
        this.service = service;

    }

    @PostMapping("/customer-loans")
    public ResponseEntity<ResponseCustomerDTO> responseLoans (@Valid @RequestBody RequestCustomerDTO dto){
        ResponseCustomerDTO res = service.loans(dto);
        return  ResponseEntity.ok(res);
    }
}
