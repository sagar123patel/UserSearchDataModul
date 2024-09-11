package com.UserSearchDataModul.UserSearchDataModul.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserSearchDataModul.UserSearchDataModul.dto.AdminDto;
import com.UserSearchDataModul.UserSearchDataModul.model.Admin;
import com.UserSearchDataModul.UserSearchDataModul.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	public void saveAdmin(AdminDto adminDto) {
		Admin admin = new Admin();
		admin.setName(adminDto.getName());
		admin.setAddress(adminDto.getAddress());
		adminRepository.save(admin);
	}
	
	
	public List<Admin> getAllAdmins() {
	    return adminRepository.findAll();
	}
	
	public List<Admin> getEmployeesByAddress(String address) {
        return adminRepository.findByAddressContainingIgnoreCase(address);
    }
	
}