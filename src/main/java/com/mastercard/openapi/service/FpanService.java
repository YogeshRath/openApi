package com.mastercard.openapi.service;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.mastercard.openapi.pojo.SearchFPANRequest;

@Service
public interface FpanService {

	void fpanSearch(SearchFPANRequest fpanRequest,HttpHeaders headers);
}
