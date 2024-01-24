package com.example.cafemanagementsystem.serviceimpl;

import com.example.cafemanagementsystem.constants.CafeConstants;
import com.example.cafemanagementsystem.dao.UserDao;
import com.example.cafemanagementsystem.model.User;
import com.example.cafemanagementsystem.service.UserService;
import com.example.cafemanagementsystem.utils.CafeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
log.info("Inside signup{}", requestMap);
    if (validateSignUpMap(requestMap)){
        User user = userDao.findByEmaild(requestMap.get("email"));
        if (Objects.isNull(user)){
          //  userDao.save(getUserFromMap(requestMap));
            return  CafeUtils.getResponseEntity("Successfully Registered.", HttpStatus.OK);
        }else {
            return CafeUtils.getResponseEntity(CafeConstants.INVALID_DATA, HttpStatus.MULTI_STATUS);
        }
    }
    else {
        return CafeUtils.getResponseEntity(CafeConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
    }
   // return null;
    }

    private boolean validateSignUpMap(Map<String, String> requestMap) {
      if ( requestMap.containsKey("name") && requestMap.containsKey("password") && requestMap.containsKey("email") && requestMap.containsKey("password")){
          return true;
      }
      return false;
    }

    private  User getUserFromMap(Map<String,String> requestMap) {
        User user = new User();
        user.setName(requestMap.get("name"));
        user.setContactNumber(requestMap.get("contactNumber"));
        user.setStatus(requestMap.get("false"));
        user.setRole("user");
        user.setPassword(requestMap.get("password"));
        user.setEmail(requestMap.get("email"));
        return user;
    }


}
