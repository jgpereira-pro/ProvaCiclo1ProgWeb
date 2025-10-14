package com.senac.joaog.service;

import com.senac.joaog.entity.Atendente;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {

    private Atendente atendente;

    public UserDetailsImpl(Atendente atendente) {
        this.atendente = atendente;
    }

    // --- MÉTODO ADICIONADO ---
    public int getId() {
        return atendente.getId();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return atendente.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return atendente.getChaveAcesso();
    }

    @Override
    public String getUsername() {
        return atendente.getUsuarioLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return atendente.getAtivo() == 1;
    }
}