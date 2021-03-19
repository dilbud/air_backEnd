package com.dbx.air.mvc.rest.controller;

import com.dbx.air.mvc.rest.entity.SuccessMsg;
import com.dbx.air.mvc.rest.entity.User;
import com.dbx.air.mvc.rest.exception.UserNotFoundException;
import com.dbx.air.mvc.rest.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

/**
 * login request handler
 */
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
@RequestMapping("/login")
public class LoginRestController {

    private UserServiceInterface userService;

    @Autowired
    public LoginRestController(UserServiceInterface userService) {
        this.userService = userService;
    }

    /**
     * @param user
     * @param userId
     * @param response
     * @return SuccessMsg JSON object
     * @throws Exception
     */
    @PostMapping("/users")
    public SuccessMsg<User> login(
            @RequestBody User user,
            @CookieValue(value = "userId", defaultValue = "0") int userId,
            HttpServletResponse response) throws Exception {
        System.out.println("this is userId from cookie " + userId);
        User updatedUser = userService.getUser(user.getEmail(), user.getPassword());
        if (updatedUser == null) {
            throw new UserNotFoundException();
        }
        Cookie cookie = new Cookie("userId", Integer.toString(updatedUser.getId()));
        cookie.setMaxAge(1000 * 60 * 60);
        response.addCookie(cookie);

        SuccessMsg<User> msg = new SuccessMsg<User>();
        msg.setData(updatedUser);
        msg.setTimeStamp(LocalDateTime.now().toString());
        msg.setMessage("Login Success");
        msg.setStatus("200");

        return msg;
    }

}