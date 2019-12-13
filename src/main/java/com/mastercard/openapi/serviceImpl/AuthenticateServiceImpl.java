package com.mastercard.openapi.serviceImpl;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import com.mastercard.developer.oauth.OAuth;
import com.mastercard.developer.utils.AuthenticationUtils;
import com.mastercard.openapi.service.AuthenticateService;

@Component
public class AuthenticateServiceImpl  implements AuthenticateService{
	
	static String consumerKey = "WBbrqlkw2kWBWJZX6lJKYqVMS9v8u1M0L0pv6pEg2baa672b!f857d27a55db4649803f165a4babde200000000000000000";
	static String sandBoxUrl = "https://sandbox.api.mastercard.com/mdes";
	
	static String file_path = "C:\\Users\\ADMIN\\Desktop\\POC-051219\\POC-FPAN-API-sandbox.p12";
	static String base_path = "https://stage.api.mastercard.com/zapp/pba/fpan/searchs";

	@Override
	public HttpHeaders getAuthorizedHeaderes(HttpHeaders headers) {
		PrivateKey signingKey;
		HttpHeaders header= new HttpHeaders();
		try {
			 signingKey = AuthenticationUtils.loadSigningKey(file_path, "keyalias", "keystorepassword");
			 header = authenticateRequest(sandBoxUrl,consumerKey,signingKey,headers);
			 
		} catch (UnrecoverableKeyException | NoSuchProviderException | KeyStoreException | CertificateException
				| NoSuchAlgorithmException | IOException e) {
			e.printStackTrace();
		}
		return header;
	}

	private HttpHeaders authenticateRequest(String sandBoxUrl2, String consumerKey2, PrivateKey signingKey,
			HttpHeaders headers) {

		URI uri = URI.create(sandBoxUrl2);
		String authHeader=OAuth.getAuthorizationHeader(uri, "POST", "", StandardCharsets.UTF_8, consumerKey2, signingKey);
		System.out.println("Authheader generted .... "+authHeader);
		headers.set("Authorization",authHeader);
		return headers;
	}

	

}
