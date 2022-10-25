package com.example.demo.service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CustomerRewardsQuarterReportsResp;
import com.example.demo.dto.CustomerSpentRewardsDto;
import com.example.demo.exception.CustomerSpentValueException;
import com.example.demo.model.CustomerSpendRewards;
import com.example.demo.model.MonthlyResultMapping;
import com.example.demo.repository.CustomerSpentRewardRepository;


@Service
@Transactional
public class CustomerSpendRewardServiceImpl implements CustomerSpendRewardService {

	private static final Logger logger = LogManager.getLogger(CustomerSpendRewardServiceImpl.class);

	@Autowired
	private CustomerSpentRewardRepository customerSpentRewardRepository;

	@Override
	public CustomerSpendRewards createRewards(CustomerSpentRewardsDto customerSpentRewardsDto) {

		logger.info(customerSpentRewardsDto.toString());
		Integer spent = customerSpentRewardsDto.getSpent();
	
		Integer rewardsPoints = 0;

		if (customerSpentRewardsDto.getPurchaseDate() == null) {
			Calendar calendar = Calendar.getInstance();
			java.sql.Date sqlDate = new Date((calendar.getTime()).getTime());
			customerSpentRewardsDto.setPurchaseDate(sqlDate);
		}

		if (spent != null) {

			rewardsPoints = calculateRewards(spent);
			logger.info("spent=" + spent +" , rewardsPoints="+rewardsPoints );

		}
		return customerSpentRewardRepository.createRewards(customerSpentRewardsDto, rewardsPoints);

	}

	public Integer calculateRewards(Integer spent) {
		
		if (spent<0) {
			logger.error("spent can't be nagtive value");
			throw new CustomerSpentValueException();
		}
		
		if (spent >= 100) {
			return (spent - 100) * 2 + 50;
		}

		else if (spent >= 50) {
			return spent - 50;

		}
		return 0;
	}

	@Override
	public CustomerRewardsQuarterReportsResp getCustomerRewardsQuarterReportsResp(Integer userId) {
		List<MonthlyResultMapping> result = customerSpentRewardRepository.getCustomerRewardsMonthReports(userId);

		CustomerRewardsQuarterReportsResp quarterReportsResp = new CustomerRewardsQuarterReportsResp();
		quarterReportsResp.setMonthReport(result);

		Integer quarterTotal = result.stream().mapToInt(x -> x.getMonthTotal()).sum();
		quarterReportsResp.setQuarterTotal(quarterTotal);
		return quarterReportsResp;
	}

}
