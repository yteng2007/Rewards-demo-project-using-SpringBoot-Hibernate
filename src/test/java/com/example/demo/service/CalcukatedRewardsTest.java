package com.example.demo.service;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalcukatedRewardsTest {

	CustomerSpendRewardServiceImpl customerSpendRewardServiceImpl;

    @BeforeEach                                         
    void setUp() {
    	customerSpendRewardServiceImpl = new CustomerSpendRewardServiceImpl();
    }

    @ParameterizedTest
    @CsvSource({"0,0", "50,0","70,20", "120,90"})
    void toUpperCase_ShouldGenerateTheExpectedUppercaseValue(Integer input, Integer expected) {
        Integer actualValue = customerSpendRewardServiceImpl.calculateRewards(input);
        assertEquals(expected, actualValue);
    }

}
