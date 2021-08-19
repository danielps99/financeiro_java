package br.com.bdws.financeiro.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ApiResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler({Exception.class})
    public void handleRuntimeException(HttpServletRequest request, Exception ex) {
        String messageLog = String.format("Url: %s . Exception: %s.", request.getRequestURI(), ex.getMessage());
        logger.error(messageLog);
        ex.printStackTrace();
    }
}
