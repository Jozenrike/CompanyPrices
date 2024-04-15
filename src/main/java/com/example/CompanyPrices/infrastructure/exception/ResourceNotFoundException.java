package com.example.CompanyPrices.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "The target price could not be found in the system")
public class ResourceNotFoundException extends RuntimeException{
}

