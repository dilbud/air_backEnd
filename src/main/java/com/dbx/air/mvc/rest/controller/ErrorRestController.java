package com.dbx.air.mvc.rest.controller;

import com.dbx.air.mvc.rest.exception.BadRequestException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * map all request to bad request
 */
@CrossOrigin(
        origins = "http://localhost:4200",
        allowCredentials = "true",
        methods =
                {
                        RequestMethod.GET,
                        RequestMethod.POST,
                        RequestMethod.PUT,
                        RequestMethod.DELETE
                })
@RestController
@RequestMapping(value = "/**")
public class ErrorRestController {
    /**
     * @throws Exception handle all request method
     */
    @RequestMapping
    public void renderErrorPage() throws Exception {
        throw new BadRequestException();
    }
}