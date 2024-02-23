//package com.ecom.controller;
//
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ecom.payload.ApiResponse;
//import com.ecom.payload.RoleDto;
//import com.ecom.service.RoleService;
//
//@RestController
//@RequestMapping("/api/auth/{userid}/role")
//
//public class RoleController {
//	
//	@Autowired
//	RoleService roleservice;
//	
//	
//	//@PreAuthorize("hasRole('ADMIN')")
//    @PostMapping("/")
//    public ResponseEntity<RoleDto> createUser(
//            @Valid @RequestBody RoleDto roleDto
//    ) {
//		RoleDto Role1 = this.roleservice.createRole(roleDto);
//        return new ResponseEntity<RoleDto>(Role1, HttpStatus.CREATED);
//    }
//	
//	@PreAuthorize("hasRole('NORMAL')")
//    @GetMapping("/")
//    public ResponseEntity<List<RoleDto>> getRoles(
//
//    ) {
//        List<RoleDto> Roles =
//                this.roleservice.getRole();
//        return new ResponseEntity<List<RoleDto>>(Roles, HttpStatus.OK);
//    }
//	
//	@PutMapping("/{roleid}")
//    public ResponseEntity<RoleDto> update(
//            @RequestBody RoleDto roleDto,
//            @PathVariable Integer roleid
//    ) {
//		RoleDto update = this.roleservice.update(roleDto, roleid);
//        return new ResponseEntity<>(update, HttpStatus.OK);
//    }
//	
//	@DeleteMapping("/role/{roleId}")
//    public ApiResponse delete(@PathVariable Integer roleid)
//    {
//    	this.roleservice.delete(roleid);
//    	return new ApiResponse("role successfully deleted",true, HttpStatus.OK);
//    }
//
//
//}
