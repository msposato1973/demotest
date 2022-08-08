package com.gocity.demo.service.exception;
 
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.gocity.demo.model.ErrorResponse;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomizedResponseEntityExceptionHandler.class);
	/***
	 * @author massimo.sposato
	 * @see 
	 * @exception CustomersNotFoundException ex
	 * @param ex
	 * @param request
	 * @return ResponseEntity<Object>
	 */
	@ExceptionHandler(value = CustomersNotFoundException.class)
    public ResponseEntity<Object> handleCustomNotFoundException(CustomersNotFoundException ex, WebRequest request) {
	  ErrorResponse errorResponse  = new ErrorResponse("404", ex.getMessage());
	  logger.error("error msg : " + ex.getMessage());
      return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
	 
	/***
	 * @author massimo.sposato
	 * @see 
	 * @exception CustomersForbiddenException ex
	 * @param ex
	 * @param request
	 * @return ResponseEntity<Object>
	 */
	@ExceptionHandler(value = CustomersForbiddenException.class)
    public ResponseEntity<Object> handleCustomNotFoundException(CustomersForbiddenException ex, WebRequest request) {
	  ErrorResponse errorResponse  = new ErrorResponse("403", ex.getMessage());
	  logger.error("error msg : " + ex.getMessage());
      return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }
	
	/***
	 * @paramMethodArgumentNotValidException ex, 
	 * @param HttpHeaders headers, 
     * @param HttpStatus status, 
     * @param WebRequest request
	 */
	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorResponse errorDetails = new ErrorResponse("400", ex.getMessage());
		  logger.error("error msg : " + ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
	
	
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
		  return new ResponseEntity<>(new ErrorResponse("500", "Internal Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
	} 

}
