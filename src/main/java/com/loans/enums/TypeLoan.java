package com.loans.enums;

import lombok.Getter;

@Getter
public enum TypeLoan {
    PERSONAL(4),
    GUARANTEED(3),
    CONSIGNMENT(2);

    private final Integer interest_rate;

    TypeLoan(Integer interest_rate) {
        this.interest_rate = interest_rate;
    }

}
