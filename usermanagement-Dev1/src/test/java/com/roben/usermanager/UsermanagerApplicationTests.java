package com.roben.usermanager;

import com.roben.usermanager.adapter.DTO.AuthenticationDTO;
import com.roben.usermanager.adapter.DTO.EmailDTO;
import com.roben.usermanager.adapter.DTO.NewUserDTO;
import com.roben.usermanager.adapter.UserControler;
import com.roben.usermanager.core.security.entitys.UserRole;
import com.roben.usermanager.core.security.entitys.Users;
import com.roben.usermanager.core.services.TokenService;
import com.roben.usermanager.core.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;

@SpringBootTest
class UsermanagerApplicationTests {



	@Test
	void contextLoads() {
	}

}
