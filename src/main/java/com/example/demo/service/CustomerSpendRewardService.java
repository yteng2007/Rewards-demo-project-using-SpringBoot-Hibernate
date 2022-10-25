package com.example.demo.service;

import com.example.demo.dto.CustomerRewardsQuarterReportsResp;
import com.example.demo.dto.CustomerSpentRewardsDto;
import com.example.demo.model.CustomerSpendRewards;

public interface CustomerSpendRewardService {

	public CustomerSpendRewards createRewards(CustomerSpentRewardsDto customerPurchase);

	public CustomerRewardsQuarterReportsResp getCustomerRewardsQuarterReportsResp(Integer userId);

}
