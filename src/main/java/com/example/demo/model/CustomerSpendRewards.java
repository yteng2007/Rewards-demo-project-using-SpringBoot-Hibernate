package com.example.demo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@SqlResultSetMapping(name = "MonthlyReportResultMapping", classes = {
		@ConstructorResult(columns = { @ColumnResult(name = "monthNumber", type = Integer.class),
				@ColumnResult(name = "monthTotal", type = Integer.class) }, targetClass = MonthlyResultMapping.class) })
@NamedNativeQuery(name = "MonthlyReport", query = " SELECT EXTRACT(MONTH FROM PURCHASE_DATE) as monthNumber ,sum(REWARDS_POINTS) as monthTotal \n"
		+ " FROM CUSTOMER_SPEND_REWARDS \n"
		+ " WHERE USER_ID=? and PURCHASE_DATE >= DATEADD(MONTH, -3, NOW()) \n"
		+ "  GROUP BY EXTRACT(MONTH FROM PURCHASE_DATE)  \n"
		+ "ORDER BY  EXTRACT(MONTH FROM PURCHASE_DATE)   DESC;", resultSetMapping = "MonthlyReportResultMapping")
@Entity
@Table(name = "customerSpendRewards")

public class CustomerSpendRewards {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Integer id;

	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "spent")
	private Integer spent;

	@Column(name = "purchase_date", columnDefinition = "DATE DEFAULT CURRENT_DATE")
	private Date purchaseDate;

	@Column(name = "rewards_points")
	private Integer rewardsPoints;

	public CustomerSpendRewards() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerSpendRewards(Integer id, Integer userId, Integer spent, Date purchaseDate, Integer rewardsPoints) {
		super();
		this.id = id;
		this.userId = userId;
		this.spent = spent;
		this.purchaseDate = purchaseDate;
		this.rewardsPoints = rewardsPoints;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getSpent() {
		return spent;
	}

	public void setSpent(Integer spent) {
		this.spent = spent;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Integer getRewardsPoints() {
		return rewardsPoints;
	}

	public void setRewardsPoints(Integer rewardsPoints) {
		this.rewardsPoints = rewardsPoints;
	}

}