package com.juanmafe.newsletter;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Newsletter Response Exception Handler.
 * @author juanmafe.
 */
@ControllerAdvice
public class NewsletterResponseExceptionHandler {

	@ControllerAdvice
	public class NewsletterExceptionHandler extends ResponseEntityExceptionHandler {

		@Override
		protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
			var body = new LinkedHashMap<String, Object>();
			body.put("time", new Date());
			body.put("status code", status.value());
			body.put("status desc", status.getReasonPhrase());
			body.put("errors", ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList()));
			return new ResponseEntity<>(body, headers, status);
		}
	}
}