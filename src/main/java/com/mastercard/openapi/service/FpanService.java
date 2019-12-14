package com.mastercard.openapi.service;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.mastercard.openapi.pojo.LocalSearchFPANRequest;

@Service
public interface FpanService {

	void fpanSearch(LocalSearchFPANRequest fpanRequest,HttpHeaders headers);
}
