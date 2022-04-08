package com.the.simone.seor.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.the.simone.seor.model.Otp;
import com.the.simone.seor.model.error.OtpExc;
import com.the.simone.seor.model.response.OtpResponse;
import com.the.simone.seor.repo.OtpRepo;

@Service
public class OtpService {
	
	
	// BEANS
	@Autowired 
	private OtpRepo otpRepo;
	
	@Cacheable("otp")
	public OtpResponse inserisciDati(Otp request) {
		
		OtpResponse response = new OtpResponse();
		Otp responseDTO = null;
		String result = "";
		try {
		responseDTO = otpRepo.save(request); 
		result = "OK";
		}catch(Exception e) {
			result = "KO";
		}
		response.setResult(result);
		response.setTransactionId(responseDTO.getTransactioId());
		return response;
	}
	//
	@Cacheable("otp")
	public Optional<Otp> getOtp(long transacionId) throws OtpExc{
		
		Optional<Otp> response = null;
		
		response = otpRepo.findById(transacionId);
		
		if(response == null)
			throw new OtpExc();
		
		return response;
		
	}
	@CacheEvict(value="otp", key="#transactionId")
	public String deleteOperation(long transactionId) throws OtpExc{
		
		String response ="";
		
		try {
			otpRepo.deleteById(transactionId);
			response = "OK";
		}catch(Exception e) {
			throw new OtpExc();
		}
		
		return response;
	}

}
