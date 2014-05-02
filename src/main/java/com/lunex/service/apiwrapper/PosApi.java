package com.lunex.service.apiwrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.lunex.service.apiwrapper.posapi.Account;
import com.lunex.service.apiwrapper.posapi.AccountResponse;
import com.lunex.service.apiwrapper.posapi.PosApiException;

public class PosApi extends BaseXmlApi {
	public PosApi(String target) {
		super(target);
	}
	
	public List<Account> listAccount(String seller, String pin) {
		return listAccount(seller, null, null, pin, null);
	}
	
	public List<Account> listAccount(String seller, String sku, String phone) {
		return listAccount(seller, sku, phone, null, null);
	}
	
	public List<Account> listAccount(String seller, String sku, String phone, String pin, String detail) {
		HashMap<String, String> queryParams = new HashMap<String, String>();
		if (sku != null) {
			queryParams.put("sku", sku);
		}
		if (phone != null) {
			queryParams.put("phone", phone);
		}
		if (pin != null) {
			queryParams.put("pin", pin);
		}
		if (detail != null) {
			queryParams.put("detail", detail);
		}
		
		List<Account> accounts = new ArrayList<Account>();
		Account[] listAccounts = this.get(String.format("sellers/%s/pin/", seller), queryParams, Account[].class);
		for (Account acct : listAccounts) {
			accounts.add(acct);
		}
		return accounts;
	}
	
	public Account getAccount(String seller, String sku, String phone) throws PosApiException {
		AccountResponse account = this.get(String.format("sellers/%s/sku/%s/phone/%s", seller, sku, phone), null, AccountResponse.class);
		if (account.code < 0) {
			throw new PosApiException(account.code, account.message);
		}
		return account.account;
	}
}
