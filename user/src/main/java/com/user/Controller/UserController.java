package com.user.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.user.Enitity.User;
import com.user.Service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public String userList(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "user-list";
	}

	@GetMapping("/users/new")
	public String newUserForm(Model model) {
		model.addAttribute("user", new User());
		return "user-form";
	}

	@GetMapping("/users/edit/{id}")
	public String editUserForm(@PathVariable("id") Long id, Model model) {
		User user = userService.getUserById(id);
		if (user == null) {
			return "redirect:/users";
		}
		model.addAttribute("user", user);
		return "user-update";
	}

	@PostMapping("/users/save")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.saveOrUpdateUser(user);
		return "redirect:/users";
	}

	@PostMapping("/users/disable/{id}")
	public String disableUser(@PathVariable("id") Long id) {
		userService.disableUser(id);
		return "redirect:/users";
	}
	@PostMapping("/users/updateEnabledStatus")
    public ResponseEntity<?> updateEnabledStatus(@RequestParam("userId") Long userId,
                                                      @RequestParam("enabled") boolean enabled) {
                userService.updateEnabledStatus(userId, enabled);
        
       return  ResponseEntity.ok("User's enabled status updated successfully");
    }
}
