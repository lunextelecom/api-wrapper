package com.lunex.service.apiwrapper.posapi;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Account")
public class Account {
	@XmlElement(name="AutoRefillUpdatedBy")
	public String autoRefillUpdatedBy;
	@XmlElement(name="Balance")
	public BigDecimal balance;
	@XmlElement(name="City")
	public String city;
	@XmlElement(name="Created")
	public Date created;
	@XmlElement(name="CreatedBy")
	public String createdBy;
	@XmlElement(name="Currency")
	public String currency;
	@XmlElement(name="Email")
	public String email;
	@XmlElement(name="FirstName")
	public String firstName;
	@XmlElement(name="FirstPurchaseDate")
	public Date firstPurchaseDate;
	@XmlElement(name="FirstUseDate")
	public Date firstUseDate;
	@XmlElement(name="LastName")
	public String lastName;
	@XmlElement(name="LastPurchaseDate")
	public Date lastPurchaseDate;
	@XmlElement(name="LastUseDate")
	public Date lastUseDate;
	@XmlElement(name="MinBalance")
	public BigDecimal minBalance;
	@XmlElement(name="Notes")
	public String notes;
	@XmlElement(name="Phone")
	public String phone;
	@XmlElement(name="Pin")
	public String pin;
	@XmlElement(name="RedeemDate")
	public Date redeemDate;
	@XmlElement(name="ReferralName")
	public String referralName;
	@XmlElement(name="ReferralPhone")
	public String referralPhone;
	@XmlElement(name="RefillAmt")
	public BigDecimal refillAmt;
	@XmlElement(name="Sku")
	public String sku;
	@XmlElement(name="State")
	public String state;
	@XmlElement(name="StatementOption")
	public String statementOption;
	@XmlElement(name="Street")
	public String street;
	@XmlElement(name="Zipcode")
	public String zipcode;	
}
