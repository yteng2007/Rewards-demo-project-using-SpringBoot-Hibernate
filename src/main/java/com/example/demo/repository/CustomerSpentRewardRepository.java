package com.example.demo.repository;

import java.util.List;

import com.example.demo.dto.CustomerSpentRewardsDto;
import com.example.demo.model.CustomerSpendRewards;
import com.example.demo.model.MonthlyResultMapping;

public interface CustomerSpentRewardRepository {

	CustomerSpendRewards createRewards(CustomerSpentRewardsDto customerSpentRewardsDto, Integer rewardsPoints);

	List<MonthlyResultMapping> getCustomerRewardsMonthReports(Integer userId);
}
