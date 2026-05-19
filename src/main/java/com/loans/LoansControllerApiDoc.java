package com.loans;


import com.loans.dto.request.RequestCustomerDTO;
import com.loans.dto.response.ResponseCustomerDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Loans", description = "Route to get available loans")
public interface LoansControllerApiDoc {
    @PostMapping
    @Operation(summary = "Evaluate available loans", description = "Checks the available loans based on customer information")
    @ApiResponse(responseCode = "200", description = "Loans calculated successfully")
    @ApiResponse(responseCode = "400", description = "Validation error in the provided data")
    public ResponseEntity<ResponseCustomerDTO> responseLoans (@Valid @RequestBody RequestCustomerDTO dto);


}
