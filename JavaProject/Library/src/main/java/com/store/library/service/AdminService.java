package com.store.library.service;

import com.store.library.dto.AdminDto;
import com.store.library.model.Admin;

public interface AdminService {
    Admin findByUsername(String username);
    Admin save(AdminDto saveAdminDto);
}
