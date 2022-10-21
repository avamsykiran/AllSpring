package in.tp.ssd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.tp.ssd.dao.AppRoleRepo;
import in.tp.ssd.dao.AppUserRepo;
import in.tp.ssd.dao.AppUserRoleRepo;
import in.tp.ssd.model.AppUser;
import in.tp.ssd.model.UserRole;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private AppUserRepo appUserDAO;
 
    @Autowired
    private AppRoleRepo appRoleDAO;
    
    @Autowired
    private AppUserRoleRepo appUserRoleDAO;
 
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUser appUser = this.appUserDAO.findByUserName(userName);
 
        if (appUser == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }
 
        // [ROLE_USER, ROLE_ADMIN,..]
        List<UserRole> userRoles = this.appUserRoleDAO.findAllByAppUser(appUser);
 
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (userRoles != null) {
            for (UserRole role : userRoles) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role.getAppRole().getRoleName());
                grantList.add(authority);
            }
        }
 
        UserDetails userDetails = (UserDetails) new User(appUser.getUserName(), 
                appUser.getEncrytedPassword(), grantList);
 
        return userDetails;
    }
 
}