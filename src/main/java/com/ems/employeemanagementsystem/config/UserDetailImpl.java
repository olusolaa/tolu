package com.ems.employeemanagementsystem.config;
import com.ems.employeemanagementsystem.Models.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class UserDetailImpl implements UserDetails {

    private static final long serialVersionUID = 1L;
    private Long id;
    private  String username;
    private  String password;

    private Collection<? extends GrantedAuthority> grantedAuthorities;

    public static UserDetails buildUserDetail(Users user) {
        List<GrantedAuthority> grantedAuthorities = user.getRoles().stream()
                .map(userRole -> new SimpleGrantedAuthority(userRole.getRoleEnum().name()))
                .collect(Collectors.toList());
        return new UserDetailImpl(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                grantedAuthorities
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
        return true;
    }

}
