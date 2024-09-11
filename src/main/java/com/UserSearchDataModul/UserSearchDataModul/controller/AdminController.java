package com.UserSearchDataModul.UserSearchDataModul.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.UserSearchDataModul.UserSearchDataModul.dto.AdminDto;
import com.UserSearchDataModul.UserSearchDataModul.model.Admin;
import com.UserSearchDataModul.UserSearchDataModul.service.AdminService;

import jakarta.validation.Valid;

@Controller
public class AdminController {

	@Autowired
    private AdminService adminService;

//    @GetMapping("/admins")
//    public String getAdminsByAddress(@RequestParam("address") String address, Model model) {
//        List<Admin> admins = adminService.getEmployeesByAddress(address);
//        model.addAttribute("admins", admins); // Corrected "amdins" typo
//        return "adminList"; // Return the HTML page
//    }
    
    
    
    @GetMapping("/admins")
    public String getAdminsByAddress(@RequestParam(value = "address", required = false) String address, Model model) {
        List<Admin> admins;

        if (address != null && !address.isEmpty()) {
            admins = adminService.getEmployeesByAddress(address);
        } else {
            admins = adminService.getAllAdmins(); // Implement a method to fetch all admins if no filter is applied
        }

        model.addAttribute("admins", admins);
        return "adminList"; // Return the HTML page
    }

    
    

    @PostMapping("/index")
    public String handleSignUp(@ModelAttribute("admin") @Valid AdminDto adminDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "index";
        }

        try {
            adminService.saveAdmin(adminDTO);
        } catch (Exception e) {
            model.addAttribute("errorMessage", "An error occurred while processing your request.");
            return "index";
        }

        model.addAttribute("admin", adminDTO);
        return "submittedAdminInfo";
    }

    @GetMapping("/index")
    public String showSignUpForm(Model model) {
        model.addAttribute("admin", new AdminDto());
        return "index";
    }

    @GetMapping("/addAdminForm")
    public String showAddAdminForm(Model model) {
        model.addAttribute("admin", new AdminDto());
        return "index"; // Reuse the index page for adding an admin
    }
	
}
