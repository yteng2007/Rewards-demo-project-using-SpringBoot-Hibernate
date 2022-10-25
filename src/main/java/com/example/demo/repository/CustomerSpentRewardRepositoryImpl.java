package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.CustomerSpentRewardsDto;
import com.example.demo.model.CustomerSpendRewards;
import com.example.demo.model.MonthlyResultMapping;


@Repository
@Transactional
public class CustomerSpentRewardRepositoryImpl implements CustomerSpentRewardRepository {

	@PersistenceContext
	private  EntityManager em;
	
	
	private static final Logger logger = LogManager.getLogger(CustomerSpentRewardRepositoryImpl.class);


	@Override
	public CustomerSpendRewards  createRewards(CustomerSpentRewardsDto customerSpentRewardsDto, Integer rewardsPoints) {
		
		
			CustomerSpendRewards customerSpendRewards = new CustomerSpendRewards();
			customerSpendRewards.setUserId(customerSpentRewardsDto.getUserId());
			customerSpendRewards.setSpent(customerSpentRewardsDto.getSpent());
			customerSpendRewards.setRewardsPoints(rewardsPoints);
			customerSpendRewards.setPurchaseDate(customerSpentRewardsDto.getPurchaseDate());
			
			em.persist(customerSpendRewards);
					
		
		return customerSpendRewards;
	}


	@Override
	public List<MonthlyResultMapping> getCustomerRewardsMonthReports(Integer userId) {
		TypedQuery<MonthlyResultMapping> query =  (TypedQuery<MonthlyResultMapping>) em.createNamedQuery("MonthlyReport", MonthlyResultMapping.class);
		List<MonthlyResultMapping>  result=query.setParameter(1, userId).getResultList();
		logger.info("getCustomerRewardsMonthReports return recorder size="+result.size());
		
		for (MonthlyResultMapping record:result) {
			logger.info(record.toString());
		}
		return result;
	}
	
}
