package com.user.Service;

import java.util.List;

import com.user.Enitity.User;

public interface UserService {

	List<User> getAllUsers();
	User getUserById(Long id);
	void saveOrUpdateUser(User user);
	void disableUser(Long id);
	void updateEnabledStatus(Long userId, boolean enabled);

}
