package com.dbx.air.mvc.rest.controller;

import com.dbx.air.mvc.rest.exception.BadRequestException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorRestController {
    @RequestMapping
    public void renderErrorPage() throws Exception {
//        return new ResponseEntity<>("ffff", HttpStatus.NOT_FOUND);
        throw new BadRequestException();
    }
}
