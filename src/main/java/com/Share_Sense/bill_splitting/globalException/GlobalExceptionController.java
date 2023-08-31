package com.Share_Sense.bill_splitting.globalException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<ErrorResponse> handleNumberFormat(Exception e) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		return new ResponseEntity<>(new ErrorResponse(status, "enter positive numbers only "), status);
	}

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ErrorResponse> handleBussinessException(Exception e) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		return new ResponseEntity<>(new ErrorResponse(status, e.getMessage()), status);
	}
}
