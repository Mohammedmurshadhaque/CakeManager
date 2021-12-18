package com.waracle.cakemgr.cakemanager;

import com.waracle.cakemgr.cakemanager.entity.Cake;
import com.waracle.cakemgr.cakemanager.entity.User;
import com.waracle.cakemgr.cakemanager.repository.CakeRepository;
import com.waracle.cakemgr.cakemanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.util.ArrayList;
import java.util.List;

@EnableAuthorizationServer
@EnableResourceServer
@RequiredArgsConstructor
@SpringBootApplication
public class CakemanagerApplication implements CommandLineRunner {

	private final CakeRepository cakeRepository;
	private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(CakemanagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Cake> cakeList = new ArrayList<>();
		cakeList.add(Cake.builder().firstName("Yaseen").lastName("Haque").email("yaseen.haque@yahoo.com").build());
		cakeList.add(Cake.builder().firstName("Abdullah").lastName("Haque").email("abdullah.haque@gamil.com").build());
		cakeList.add(Cake.builder().firstName("Ahamd").lastName("Haque").email("ahmad.haque@gamil.com").build());
		cakeRepository.saveAll(cakeList);

		User user = new User();
		user.setId(1);
		user.setUsername("waracle");
		user.setPassword("$2a$08$fL7u5xcvsZl78su29x1ti.dxI.9rYO8t0q5wk2ROJ.1cdR53bmaVG");
		userRepository.save(user);

	}

}
