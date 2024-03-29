package dev.codex.web.application.service;

import dev.codex.web.application.ApplicationConstants;
import dev.codex.web.application.exception.ProcessingException;
import dev.codex.web.persistence.entity.UserEntity;
import dev.codex.web.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service(ApplicationConstants.USER_DETAILS_SERVICE_BEAN_NAME)
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = this.userRepository.findByUsername(username).orElse(null);
        if (user == null) {
            user =  this.userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(ProcessingException.RESOURCE_NOT_FOUND_EXCEPTION_MSG_FORMAT.formatted(UserEntity.class.getSimpleName())));
        }
        return new User(
                user.getUsername(), user.getPassword(), user.isEnabled(),
                true, true, true,
                Collections.singletonList(new SimpleGrantedAuthority("USER"))
        );
    }
}