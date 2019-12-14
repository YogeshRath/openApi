package com.mastercard.openapi.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mastercard.openapi.pojo.LocalSearchFPANRequest;
import com.mastercard.openapi.service.AuthenticateService;
import com.mastercard.openapi.service.FpanService;

@RequestMapping("/openapi")
@RestController
public class OpenApiController {

	@Autowired
	FpanService fpanService;
	
	@Autowired
	AuthenticateService authenticateService;
	
	@RequestMapping("/health")
	public String healthCheck() {
		return "Up and running";
	}
	
	@RequestMapping("/search")
	public ResponseEntity<Object> searchFpan(
			@RequestHeader(value ="X-Request-Id", required=false) String  requestId,
			@RequestHeader(value ="X-Correlation-Id", required=true) String  correlationId,
			@RequestHeader(value ="X-Participant-Id", required=true) String  participantId,
			@RequestHeader(value ="X-JWS-Signature", required=false) String  jwsSignature,
			@RequestBody LocalSearchFPANRequest fpanRequest){
		
		HttpHeaders headers= new HttpHeaders();
		headers.add("X-Request-Id", requestId);
		headers.add("X-Correlation-Id", correlationId);
		headers.add("X-Participant-Id", participantId);
		headers.add("X-JWS-Signature", jwsSignature);
		
		HttpHeaders authorizedHeaders = authenticateService.getAuthorizedHeaderes(headers);
		
		fpanService.fpanSearch(fpanRequest, authorizedHeaders);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
