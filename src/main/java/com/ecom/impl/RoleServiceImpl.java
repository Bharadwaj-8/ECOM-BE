//package com.ecom.impl;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.ecom.entity.Role;
//import com.ecom.exception.ResourceNotFoundException;
//import com.ecom.payload.RoleDto;
//import com.ecom.repository.RoleRepo;
//import com.ecom.service.RoleService;
//
//@Service
//public class RoleServiceImpl implements RoleService{
//	
//	
//	@Autowired
//	ModelMapper modelMapper;
//	
//	@Autowired
//	RoleRepo roleRepo;
//
//	
//
//	@Override
//	public RoleDto createRole(RoleDto roleDto) {
//		
//		Role role = this.modelMapper.map(roleDto, Role.class);
//
//		Role savedRole = this.roleRepo.save(role);
//
////        entity -> dto
//
//		RoleDto savedRoleDto = this.modelMapper.map(savedRole, RoleDto.class);
//        return savedRoleDto;
//
//	}
//
//	@Override
//	public List<RoleDto> getRole() {
//		
//		List<Role> Roles = this.roleRepo.findAll();
//        List<RoleDto> dtos = Roles.stream().map(cat -> this.modelMapper.map(cat, RoleDto.class)).collect(Collectors.toList());
//        return dtos;
//	}
//
//	@Override
//	public RoleDto update(RoleDto c, Integer Roleid) {
//		
//		Role role  = this.roleRepo.findById(Roleid).orElseThrow(() -> new ResourceNotFoundException("role", " role id ", Roleid + ""));
//		role.setId(c.getId());
//		role .setName(c.getName());
//		Role updatedRole = this.roleRepo.save(role);
//        return this.modelMapper.map(updatedRole, RoleDto.class);
//	}
//
//	@Override
//	public void delete(Integer Roleid) {
//		
//		Role role  = this.roleRepo.findById(Roleid).orElseThrow(() -> new ResourceNotFoundException("role", " role id ", Roleid + ""));
//		this.roleRepo.delete(role);
//		
//	}
//	
//	
//	
//
//}
