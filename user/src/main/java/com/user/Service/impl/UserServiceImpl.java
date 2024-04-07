package com.user.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.user.Enitity.User;
import com.user.Repository.UserRepository;
import com.user.Service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    @Override
    @Transactional
    public void saveOrUpdateUser(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void disableUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        userOptional.ifPresent(user -> {
            user.setEnabled(false);
            userRepository.save(user);
        });
    }

	@Override
	public void updateEnabledStatus(Long userId, boolean enabled) {
		 User user = userRepository.findById(userId).orElse(null);
	        if (user != null) {
	            user.setEnabled(enabled);
	            userRepository.save(user);
	        } 
		
		
	}
}

