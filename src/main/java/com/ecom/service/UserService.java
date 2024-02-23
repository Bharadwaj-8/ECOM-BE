package com.ecom.service;

import java.util.List;

import com.ecom.payload.RoleDto;
import com.ecom.payload.UserDto;

public interface UserService {
	
	UserDto createUser(UserDto userDto);

    UserDto updateRole(Integer userId, List<RoleDto> roles);
    
//  get

  List< UserDto> getUser();


//  update

  UserDto update( UserDto c, Integer userid);


// delete

  void delete(Integer userid);

    


}
