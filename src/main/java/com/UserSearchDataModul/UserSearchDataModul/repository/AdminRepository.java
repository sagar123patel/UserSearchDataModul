package com.UserSearchDataModul.UserSearchDataModul.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UserSearchDataModul.UserSearchDataModul.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	List<Admin> findByAddressContainingIgnoreCase(String address);

}