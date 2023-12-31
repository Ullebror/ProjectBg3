package project.bg3.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import project.bg3.validation.PasswordMatches;

@PasswordMatches
public class UserDto {
    
    @NotNull
    @NotEmpty
    private String username;
    
    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;

    
    public String getUsername() {
    	return username;
    }
    
    public void setUsername(String username) {
    	this.username=username;
    }
    
    public String getPassword() {
    	return password;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
   
    public String getMatchingPassword() {
    	return matchingPassword;
    }

    
    public void setMatchingPassword(String matchingPassword) {
    	this.matchingPassword = matchingPassword;
    }

    
} 