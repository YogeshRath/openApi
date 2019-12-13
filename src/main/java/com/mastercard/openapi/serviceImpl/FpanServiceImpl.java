package com.mastercard.openapi.serviceImpl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mastercard.openapi.pojo.SearchFPANRequest;
import com.mastercard.openapi.pojo.SearchFPANResponse;
import com.mastercard.openapi.service.FpanService;

@Component
public class FpanServiceImpl implements FpanService {

	static String serviceUrl = "https://stage.api.mastercard.com/zapp/pba/fpan/searchs";
	
	@Override
	public void fpanSearch(SearchFPANRequest fpanRequest, HttpHeaders headers) {
		System.out.println("Request executing from service impl layer...");
		HttpEntity<?> entity =new HttpEntity<>(fpanRequest,headers);
		RestTemplate restTemplate =new RestTemplate();
		ResponseEntity<SearchFPANResponse> response=restTemplate.exchange(serviceUrl, HttpMethod.POST,entity,SearchFPANResponse.class);
		
		System.out.println(" response from fpan service "+response);
	}

}
