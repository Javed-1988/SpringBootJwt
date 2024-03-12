package com.example.springbootweb.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

//    @OneToOne(targetEntity = Role.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)// one to one mapping
//    @JoinColumn(name="user_id",referencedColumnName = "id")
//    private Role role;


//    @OneToMany(targetEntity = Role.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name="user_id",referencedColumnName = "id")
//    private Set<Role> role;

    //    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JoinTable(name="user_role_mapping",
//   joinColumns ={
//            @JoinColumn(name = "user_id",referencedColumnName = "id")
//
//    },
//            inverseJoinColumns = {
//            @JoinColumn(name="role_id",referencedColumnName = "id")
//            })
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>();
        for (Role role : role) {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role.getName());
            list.add(simpleGrantedAuthority);
        }
        return list;
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
