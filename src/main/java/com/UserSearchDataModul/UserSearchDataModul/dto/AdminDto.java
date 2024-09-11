package com.UserSearchDataModul.UserSearchDataModul.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AdminDto {

	
	@NotEmpty(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

	@NotEmpty(message = "Address is required")
    @Size(min = 3, max = 50, message = "Address must be between 3 and 250 characters")
    private String address;

    
}
