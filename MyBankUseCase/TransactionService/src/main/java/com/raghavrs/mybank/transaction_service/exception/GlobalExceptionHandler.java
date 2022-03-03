package com.raghavrs.mybank.transaction_service.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


import feign.FeignException;

import org.hibernate.exception.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorResponse handleInvalidInputs(MethodArgumentNotValidException exception, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorResponse.setErrorMsg(HttpStatus.BAD_REQUEST.name());
		errorResponse.setTimestamp(LocalDateTime.now());
		List<String> details = new ArrayList<String>();
		details = exception.getBindingResult().getFieldErrors().stream().map(error -> error.getDefaultMessage())
				.collect(Collectors.toList());

		errorResponse.setDetails(String.join(", ", details));
		return errorResponse;
	}

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse globalExceptionHandler(ConstraintViolationException exception, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.setErrorMsg(HttpStatus.INTERNAL_SERVER_ERROR.name());
		errorResponse.setTimestamp(LocalDateTime.now());
		errorResponse.setDetails(exception.getCause().getMessage());
		return errorResponse;
	}

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorResponse> customExceptionHandler(CustomException exception, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode(exception.getCode());
		errorResponse.setErrorMsg(exception.getValue());
		errorResponse.setTimestamp(LocalDateTime.now());
		errorResponse.setDetails(exception.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.valueOf(errorResponse.getErrorCode()));
	}

	@ExceptionHandler(FeignException.class)
	public ResponseEntity<ErrorResponse> feignClientExceptionHandler(FeignException exception, WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse();
		
		try{
			errorResponse.setErrorCode(Integer.parseInt(
					Arrays.stream(exception.getMessage().split("[/[{,}/]]")).map(x -> x.replace("\"", "").trim())
							.filter(d -> d.startsWith("errorCode:")).toList().get(0).replace("errorCode:", "")));
		}catch (Exception e) {
			errorResponse.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		try{
			errorResponse.setErrorMsg(
					Arrays.stream(exception.getMessage().split("[/[{,}/]]")).map(x -> x.replace("\"", "").trim())
							.filter(d -> d.startsWith("errorMsg:")).toList().get(0).replace("errorMsg:", ""));
		}catch (Exception e) {
			errorResponse.setErrorMsg(HttpStatus.INTERNAL_SERVER_ERROR.name());
		}
		
		errorResponse.setTimestamp(LocalDateTime.now());
		try{
			errorResponse.setDetails(
					Arrays.stream(exception.getMessage().split("[/[{,}/]]")).map(x -> x.replace("\"", "").trim())
							.filter(d -> d.startsWith("details:")).toList().get(0).replace("details:", ""));
		}catch (Exception e) {
			errorResponse.setDetails(exception.getMessage());
		}
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.valueOf(errorResponse.getErrorCode()));
	}

}
