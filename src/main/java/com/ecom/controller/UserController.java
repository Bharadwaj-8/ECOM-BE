package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.payload.ApiResponse;
import com.ecom.payload.RoleDto;
import com.ecom.payload.UserDto;
import com.ecom.service.UserService;

@RestController
@RequestMapping("/api/user")

public class UserController {
	
	
	@Autowired
    private UserService userService;

	 //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/register")
    public ResponseEntity<UserDto> createUser(
            @RequestBody UserDto userDto
    ) {
        UserDto user = this.userService.createUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);

    }
	 
	 
	 //@PreAuthorize("hasRole('NORMAL')")
	    @GetMapping("/")
	    public ResponseEntity<List<UserDto>> getusers(

	    ) {
	        List<UserDto> Users =
	                this.userService.getUser();
	        return new ResponseEntity<List<UserDto>>(Users, HttpStatus.OK);
	    }

	 @PutMapping("/{userid}")
	    public ResponseEntity<UserDto> update(
	            @RequestBody UserDto userDto,
	            @PathVariable Integer userid
	    ) {
		 UserDto update = this.userService.update(userDto, userid);
	        return new ResponseEntity<>(update, HttpStatus.OK);
	    }
	 
	 @DeleteMapping("/{userid}")
	    public ApiResponse delete(@PathVariable Integer userid)
	    {
	    	this.userService.delete(userid);
	    	return new ApiResponse("user successfully deleted",true, HttpStatus.OK);
	    }


    //update

    //delete

    //get all users
//    @PreAuthorize("hasRole('ADMIN')")
//    @PutMapping("/users/role/{userId}")
//    public ResponseEntity<UserDto> updateRoles(
//            @PathVariable Integer userId,
//            @RequestBody List<RoleDto> roles
//    ) {
//        UserDto userDto = this.userService.updateRole(userId, roles);
//        return new ResponseEntity<>(userDto, HttpStatus.OK);
//    }

	
	

}
