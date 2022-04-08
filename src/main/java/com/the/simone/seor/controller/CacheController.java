package com.the.simone.seor.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.the.simone.seor.model.Otp;
import com.the.simone.seor.model.response.OtpResponse;
import com.the.simone.seor.service.OtpService;

@RestController
@RequestMapping("cache")
public class CacheController {
	
	@Autowired private OtpService otpService;
	
	@PostMapping("/otp/in")
	public OtpResponse insertiOtp(@RequestBody Otp request) {
		
		OtpResponse response = otpService.inserisciDati(request);

		return response;
	}
	
	@GetMapping("/otp/get/{transactionId}")
	public Optional<Otp> getOtp(@PathVariable("transactionId") long transactionId) {
		
		Optional<Otp> response = otpService.getOtp(transactionId);
		return response;
	}
	
	@DeleteMapping("/otp/delete/{transactionId}")
	public String cancellaOperazione(@PathVariable("transactionId") long transactionId) {
		String response = otpService.deleteOperation(transactionId) ;
		return response;
		
	}

}
