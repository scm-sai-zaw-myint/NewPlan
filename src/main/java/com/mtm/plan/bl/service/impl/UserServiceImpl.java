package com.mtm.plan.bl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mtm.plan.bl.service.UserService;
import com.mtm.plan.bl.dto.UserDTO;
import com.mtm.plan.persistence.entity.User;
import com.mtm.plan.persistence.repository.UserRepository;
import com.mtm.plan.web.forms.UserForm;

/**
 * Write the application business logic here... <br>
 * This the place to execute the business logic.
 *
 * @author SaiZawMyint
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUser() {
        return this.userRepository.findAll().stream().map(u -> new UserDTO(u)).toList();
    }

    @Override
    public UserDTO saveOrUpdate(UserForm form) {
        User user = new User(form);
        User createdUser = this.userRepository.save(user);
        return new UserDTO(createdUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.getUserByEmail(username);
        if(user == null) {
            throw new UsernameNotFoundException("Bad Credential!");
        }
        return new UserDTO(user);
    }

}
