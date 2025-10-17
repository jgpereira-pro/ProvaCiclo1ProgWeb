package com.senac.joaog.service;

import com.senac.joaog.entity.Atendente;
import com.senac.joaog.repository.AtendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AtendenteRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Atendente user = userRepository.findByUsuarioLogin(username).orElseThrow(() -> new RuntimeException("Atendente não encontrado."));
        return new UserDetailsImpl(user);
    }

}
