package com.rocktech.dps.service;

import com.rocktech.dps.model.JwtRequest;
import com.rocktech.dps.model.JwtResponse;
import com.rocktech.dps.model.User;
import com.rocktech.dps.repository.UserRepository;
import com.rocktech.dps.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;


    public JwtResponse generateToken(JwtRequest jwtRequest) throws Exception {
        String username = jwtRequest.getUserName();
        String password = jwtRequest.getPassword();
        authenticate(username, password);
        final UserDetails userDetails = loadUserByUsername(username);
        String token = jwtUtil.generateToken(userDetails);
            Optional<User> user = userRepository.findByUserName(username);
        if (user != null && user.isPresent()) {
        return new JwtResponse(user.get(), token);
        }

        return new JwtResponse(null, "Invalid username or password");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user;
        if (userRepository.findByUserName(username).isPresent()){
            user =userRepository.findByUserName(username).get();
            return new org.springframework.security.core.userdetails.User(
                    user.getUserName(),
                    user.getPassword(),
                    getAuthorities(user)
            );
        }
        else {
            throw new UsernameNotFoundException("Username is not valid");
        }
    }

    private Set<SimpleGrantedAuthority> getAuthorities(User user){
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_" +role.getRoleName())));
        return authorities;
    }

    private void authenticate(String username, String password) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException d){
            throw new Exception("user is disabled");
        } catch (BadCredentialsException b){
            throw new Exception("Bad credentials from user");
        }
    }
}
