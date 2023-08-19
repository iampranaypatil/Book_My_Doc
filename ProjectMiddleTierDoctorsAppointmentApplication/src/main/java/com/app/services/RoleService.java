package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.repositories.RoleRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository repo;
}
