package com.dbx.air.mvc.rest.controller;

import com.dbx.air.mvc.rest.entity.ErrorMsg;
import com.dbx.air.mvc.rest.exception.BadRequestException;
import com.dbx.air.mvc.rest.exception.InventoryNotDeleteException;
import com.dbx.air.mvc.rest.exception.InventoryNotFoundException;
import com.dbx.air.mvc.rest.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
public class UserExceptionHandlerRestAdvice {

    @ExceptionHandler
    public ResponseEntity<ErrorMsg> handleException(Exception exc, HttpServletRequest httpRequest) {

        System.out.println("dddddddd "+ httpRequest.getPathInfo() + " "+ httpRequest.getMethod() + " "+ exc.getMessage());
        ErrorMsg msg = new ErrorMsg();

        msg.setStatus(String.valueOf(HttpStatus.BAD_REQUEST));
        msg.setMethod(httpRequest.getMethod());
        msg.setPath(httpRequest.getPathInfo());
        msg.setMessage("Invalid REST Request OR INTERNAL SERVER ERROR");
        msg.setTimeStamp(LocalDateTime.now().toString());

        return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorMsg> handleBadRequestException(BadRequestException exc, HttpServletRequest httpRequest) {

//        System.out.println("dddddddd "+ httpRequest.getPathInfo() + " "+ httpRequest.getMethod() + " "+ exc.getMessage());
        ErrorMsg msg = new ErrorMsg();

        msg.setStatus(String.valueOf(HttpStatus.BAD_REQUEST));
        msg.setMethod(httpRequest.getMethod());
        msg.setPath(httpRequest.getPathInfo());
        msg.setMessage("Invalid REST Request");
        msg.setTimeStamp(LocalDateTime.now().toString());

        return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorMsg> handleInventoryNotFoundException(InventoryNotFoundException exc, HttpServletRequest httpRequest) {

//        System.out.println("dddddddd "+ httpRequest.getPathInfo() + " "+ httpRequest.getMethod() + " " + exc.getMessage());
        ErrorMsg msg = new ErrorMsg();

        msg.setStatus(String.valueOf(HttpStatus.NOT_FOUND));
        msg.setMethod(httpRequest.getMethod());
        msg.setPath(httpRequest.getPathInfo());
        msg.setMessage("Inventory Not Found");
        msg.setTimeStamp(LocalDateTime.now().toString());

        return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorMsg> handleInventoryNotDeleteException(InventoryNotDeleteException exc, HttpServletRequest httpRequest) {

//        System.out.println("dddddddd "+ httpRequest.getPathInfo() + " "+ httpRequest.getMethod() + " "+ exc.getMessage());
        ErrorMsg msg = new ErrorMsg();

        msg.setStatus(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
        msg.setMethod(httpRequest.getMethod());
        msg.setPath(httpRequest.getPathInfo());
        msg.setMessage("Inventory Not Delete");
        msg.setTimeStamp(LocalDateTime.now().toString());

        return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorMsg> handleUserNotFoundException(UserNotFoundException exc, HttpServletRequest httpRequest) {

//        System.out.println("dddddddd "+ httpRequest.getPathInfo() + " "+ httpRequest.getMethod() + " "+ exc.getMessage());
        ErrorMsg msg = new ErrorMsg();

        msg.setStatus(String.valueOf(HttpStatus.NOT_FOUND));
        msg.setMethod(httpRequest.getMethod());
        msg.setPath(httpRequest.getPathInfo());
        msg.setMessage("User Not Found");
        msg.setTimeStamp(LocalDateTime.now().toString());

        return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
    }
}
