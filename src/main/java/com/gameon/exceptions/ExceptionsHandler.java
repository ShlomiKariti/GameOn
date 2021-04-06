package com.gameon.exceptions;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gameon.beans.ErrorBean;
import com.gameon.enums.ErrorType;


@RestControllerAdvice
public class ExceptionsHandler {

	@ExceptionHandler
	public ErrorBean toResponse(Exception exception, HttpServletResponse response) {

		if(exception instanceof ApplicationException) {
			ApplicationException appException = (ApplicationException) exception;
			ErrorType errorType = appException.getErrorType(); 
			int errorNumber = errorType.getErrorID();
			String errorMessage = errorType.getErrorMessage();
			
			if(errorType.isShowTrace()) {
				appException.printStackTrace();
				response.setStatus(500);
			}
			else {
				response.setStatus(400);
			}
//			response.setStatus(errorType.getErrorID());
			ErrorBean errorBean = new ErrorBean(errorNumber, errorMessage); 
			
			return errorBean;
		}
		
		exception.printStackTrace();
		response.setStatus(500);
		ErrorBean errorBean = new ErrorBean(551, "General Error");

		return errorBean;
	}

}

