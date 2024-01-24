package com.example.cafemanagementsystem.restimpl;

import com.example.cafemanagementsystem.constants.CafeConstants;
import com.example.cafemanagementsystem.rest.UserRest;
import com.example.cafemanagementsystem.service.UserService;
import com.example.cafemanagementsystem.utils.CafeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserRestimpl implements UserRest {
    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        try {
            return UserService.signUp(requestMap);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR );
    }
}
