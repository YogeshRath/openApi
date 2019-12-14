package com.mastercard.openapi.serviceImpl;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import com.mastercard.developer.mdes_digital_enablement_client.ApiClient;
import com.mastercard.developer.mdes_digital_enablement_client.ApiException;
import com.mastercard.developer.mdes_digital_enablement_client.Configuration;
import com.mastercard.developer.mdes_digital_enablement_client.api.SearchFPANRequest;
import com.mastercard.developer.mdes_digital_enablement_client.api.SearchFPANResponse;
import com.mastercard.developer.mdes_digital_enablement_client.api.SearchFpanApi;
import com.mastercard.openapi.pojo.LocalSearchFPANRequest;
import com.mastercard.openapi.service.FpanService;

@Component
public class FpanServiceImpl implements FpanService {

	//static String serviceUrl = "https://stage.api.mastercard.com/zapp/pba/fpans/searches";

	@Override
	public void fpanSearch(LocalSearchFPANRequest fpanRequest, HttpHeaders headers) {

		
		ApiClient defaultClient = Configuration.getDefaultApiClient();
	    defaultClient.setBasePath("https://api.mastercard.com/");

	    SearchFpanApi apiInstance = new SearchFpanApi(defaultClient);
	    SearchFPANRequest searchFPANRequestSchema = new SearchFPANRequest();
	    searchFPANRequestSchema.setAhiId(fpanRequest.getAhiId());
	    searchFPANRequestSchema.setAccountId(fpanRequest.getAccountId());
	    searchFPANRequestSchema.setFiConsumerId(fpanRequest.getFiConsumerId());
	    searchFPANRequestSchema.setIca(fpanRequest.getIca());
	    try {
	      SearchFPANResponse result = apiInstance.searchFpan(searchFPANRequestSchema);
	      System.out.println(result);
	    } catch (ApiException e) {
	      System.err.println("Exception when calling DeleteApi#deleteDigitization");
	      System.err.println("Status code: " + e.getCode());
	      System.err.println("Reason: " + e.getResponseBody());
	      System.err.println("Response headers: " + e.getResponseHeaders());
	      e.printStackTrace();
	    }
	}
	
	/*
	 * @Override public void fpanSearch(SearchFPANRequest fpanRequest, HttpHeaders
	 * headers) {
	 * System.out.println("Request executing from service impl layer...");
	 * HttpEntity<?> entity =new HttpEntity<>(fpanRequest,headers); RestTemplate
	 * restTemplate =new RestTemplate(); ResponseEntity<SearchFPANResponse>
	 * response=restTemplate.exchange(serviceUrl,
	 * HttpMethod.POST,entity,SearchFPANResponse.class);
	 * 
	 * System.out.println(" response from fpan service "+response); }
	 */

}
