package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.DemoApplication;
import com.example.demo.model.MonthlyResultMapping;
import com.example.demo.repository.CustomerSpentRewardRepository;

@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest(classes = DemoApplication.class)

public class GetrRewardsQuarterReportsTest {

	@Autowired
	CustomerSpentRewardRepository customerSpentRewardRepository;

	@ParameterizedTest
	@MethodSource("generateData")
	@Sql("classpath:test-data.sql")
	void shouldGetDataBit(List<MonthlyResultMapping> testDataSet) {

		List<MonthlyResultMapping> result = customerSpentRewardRepository.getCustomerRewardsMonthReports(1234);

		Assertions.assertTrue(!result.isEmpty());
		Assertions.assertTrue(result.size() == 3);// query returns 3 month even DB has 4 month data

		Assertions.assertTrue(result.containsAll(testDataSet));
		Assertions.assertTrue(testDataSet.containsAll(result));

	}

	static Stream<Arguments> generateData() {
		List<MonthlyResultMapping> testData = new ArrayList<MonthlyResultMapping>();

		MonthlyResultMapping m10 = new MonthlyResultMapping(10, 250);
		MonthlyResultMapping m9 = new MonthlyResultMapping(9, 140);
		MonthlyResultMapping m8 = new MonthlyResultMapping(8, 90);
		testData.add(m10);
		testData.add(m9);
		testData.add(m8);

		return Stream.of(Arguments.of(testData));
	}
}
