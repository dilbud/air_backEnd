package com.dbx.air.mvc.rest.controller;

import com.dbx.air.mvc.rest.exception.BadRequestException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * map all request to bad request
 */
@RestController
@RequestMapping(value = "/**")
public class ErrorRestController {
    /**
     * @throws Exception
     * handle all request method
     */
    @RequestMapping
    public void renderErrorPage() throws Exception {
        throw new BadRequestException();
    }
}