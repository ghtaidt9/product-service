package com.dailycodebuffer.ProductService.exception;

import com.dailycodebuffer.ProductService.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ProductServiceException.class)
    public ResponseEntity<ErrorResponse> handlerProductServiceException (ProductServiceException productServiceException) {
        return new ResponseEntity<>(ErrorResponse.builder()
                .errorMessage(productServiceException.getMessage())
                .errorCode(productServiceException.getErrorCode()).build(), HttpStatus.NOT_FOUND);
    }
}
