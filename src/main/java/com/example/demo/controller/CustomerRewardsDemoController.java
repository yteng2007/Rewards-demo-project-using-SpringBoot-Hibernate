package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomerRewardsQuarterReportsResp;
import com.example.demo.dto.CustomerSpentRewardsDto;
import com.example.demo.model.CustomerSpendRewards;
import com.example.demo.service.*;



@RestController
@RequestMapping("/api")
public class CustomerRewardsDemoController {

	
	@Autowired
	private CustomerSpendRewardService customerSpendRewardService;
    
    @PostMapping(path = "/spentReward", 
            consumes = MediaType.APPLICATION_JSON_VALUE, 
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerSpendRewards>  createRewards(@RequestBody CustomerSpentRewardsDto customerSpentRewardsDto) {
    	CustomerSpendRewards  customerSpendRewards = customerSpendRewardService.createRewards(customerSpentRewardsDto);
        
        return new ResponseEntity<>(customerSpendRewards, HttpStatus.OK);
    }
    
    
    @GetMapping("/spentReward/{userId}")
    public ResponseEntity<CustomerRewardsQuarterReportsResp> getById(@PathVariable Integer userId) {
 
    	CustomerRewardsQuarterReportsResp reports=customerSpendRewardService.getCustomerRewardsQuarterReportsResp(userId);
            return new ResponseEntity<>(reports, HttpStatus.OK);
      
    }
}
