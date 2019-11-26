package com.iris.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
 
@ControllerAdvice

public class ExceptionController {

	@ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ModelAndView handleError405(HttpServletRequest request, Exception e) {
        ModelAndView mav = new ModelAndView("Homepage");
        return mav;
    }

	
}
