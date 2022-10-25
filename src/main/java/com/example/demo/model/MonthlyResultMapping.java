package com.example.demo.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MonthlyResultMapping {

	@JsonProperty("Month")
	private Integer monthNumber;

	
	@JsonProperty("MonthTotal")
	private Integer monthTotal;

	public MonthlyResultMapping() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MonthlyResultMapping(Integer monthNumber, Integer monthTotal) {
		super();
		this.monthNumber = monthNumber;
		this.monthTotal = monthTotal;
	}

	public Integer getMonthNumber() {
		return monthNumber;
	}

	public void setMonthNumber(Integer monthNumber) {
		this.monthNumber = monthNumber;
	}

	public Integer getMonthTotal() {
		return monthTotal;
	}

	public void setMonthTotal(Integer monthTotal) {
		this.monthTotal = monthTotal;
	}


	@Override
	public int hashCode() {
		return Objects.hash(monthNumber, monthTotal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MonthlyResultMapping other = (MonthlyResultMapping) obj;
		return Objects.equals(monthNumber, other.monthNumber) && Objects.equals(monthTotal, other.monthTotal);
	}

	@Override
	public String toString() {
		return "MonthlyResultMapping [monthNumber=" + monthNumber + ", monthTotal=" + monthTotal + "]";
	}

}
