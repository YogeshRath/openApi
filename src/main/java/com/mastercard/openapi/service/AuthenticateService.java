package com.mastercard.openapi.service;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticateService {
	
	HttpHeaders getAuthorizedHeaderes(HttpHeaders headers);

}
