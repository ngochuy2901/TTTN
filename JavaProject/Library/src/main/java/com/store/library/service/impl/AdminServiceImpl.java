package com.store.library.service.impl;

import com.store.library.dto.AdminDto;
import com.store.library.model.Admin;
import com.store.library.repository.AdminRepository;
import com.store.library.repository.RoleRepository;
import com.store.library.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Admin findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    @Override
    public Admin save(AdminDto adminDto) {
        Admin admin = new Admin();
        admin.setFirstName(adminDto.getFirstName());
        admin.setLastName(adminDto.getLastName());
        admin.setUsername(adminDto.getPassword());
        admin.setPassword(adminDto.getPassword());
        admin.setRoles(Arrays.asList(roleRepository.findByName("ADMIN")));
        return adminRepository.save(admin);
    }
}
