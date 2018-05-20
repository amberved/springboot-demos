package com.amberved.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class RemoteAccountRepository implements AccountRepository {

	@Autowired
	protected RestTemplate restTemplate;

	protected String serviceUrl;

	public RemoteAccountRepository(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
	}

	@Override
	public List<Account> getAllAccounts() {
		Account[] accounts = restTemplate.getForObject(serviceUrl + "/accounts", Account[].class);
		
    	ObjectMapper objectMapper = new ObjectMapper();
    	objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    	String arrayToJson = null;
		try {
			arrayToJson = objectMapper.writeValueAsString(accounts);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println(arrayToJson);

		System.out.println(accounts.toString());
		return Arrays.asList(accounts);
	}

	@Override
	public Account getAccount(String number) {
		return restTemplate.getForObject(serviceUrl + "/accounts/{id}", Account.class, number);
	}

}