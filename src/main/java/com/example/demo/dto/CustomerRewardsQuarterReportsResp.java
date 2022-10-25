package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.MonthlyResultMapping;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerRewardsQuarterReportsResp {

	@JsonProperty("MonthReport")
	private List<MonthlyResultMapping>  monthReport;
	
	@JsonProperty("QuarterTotal")
	private Integer quarterTotal;

	public CustomerRewardsQuarterReportsResp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerRewardsQuarterReportsResp(List<MonthlyResultMapping> monthReport, Integer quarterTotal) {
		super();
		this.monthReport = monthReport;
		this.quarterTotal = quarterTotal;
	}

	public List<MonthlyResultMapping> getMonthReport() {
		return monthReport;
	}

	public void setMonthReport(List<MonthlyResultMapping> monthReport) {
		this.monthReport = monthReport;
	}

	public Integer getQuarterTotal() {
		return quarterTotal;
	}

	public void setQuarterTotal(Integer quarterTotal) {
		this.quarterTotal = quarterTotal;
	}

	
}
