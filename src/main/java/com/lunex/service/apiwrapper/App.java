package com.lunex.service.apiwrapper;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lunex.service.apiwrapper.posapi.Account;

/**
 * Hello world!
 */
public class App {
	final static Logger logger = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
    	logger.info("Hello World Main");
    	PosApi api = new PosApi("http://test-api.lunextelecom.com/PosService.svc/");
    	List<Account> accounts = api.listAccount("LIT1A004", "1020", "6786349017");
    	for(Account acct : accounts) {
    		logger.debug(String.format("%s %s %s %s", acct.pin, acct.phone, acct.sku, acct.created));
    	}
    }
}
