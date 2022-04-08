package com.the.simone.seor.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.the.simone.seor.model.error.BaseError;
import com.the.simone.seor.model.error.OtpExc;


@RestControllerAdvice
public class GeneralErrorService {
	
	
	// utente error handler
		@ExceptionHandler(OtpExc.class)
		@ResponseStatus(HttpStatus.NOT_FOUND)
		@ResponseBody
		public BaseError handleNoRecordFoundException(OtpExc ex) 
		{

			BaseError response = new BaseError();
			response.setErrDescr(" operazione non trovata in cache");
			response.setErrId("CAH_01");
			response.setErrType("cache_error");
			response.setError(true);
		    
		    return response;
		}
	

}
