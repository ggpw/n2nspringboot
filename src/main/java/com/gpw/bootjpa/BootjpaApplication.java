package com.gpw.bootjpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gpw.bootjpa.dao.ModuleDao;
import com.gpw.bootjpa.dao.UserDao;
import com.gpw.bootjpa.model.Module;
import com.gpw.bootjpa.model.User;

@SpringBootApplication
public class BootjpaApplication implements CommandLineRunner {

	@Autowired
	private UserDao userDao;
	@Autowired
	private ModuleDao moduleDao;

	public static void main(String[] args) {
		SpringApplication.run(BootjpaApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Set<Module> modules = new HashSet<Module>();
		for (int i = 1; i < 4; i++) {
//			Module module = new Module("module"+i, i, new HashSet<User>());
			Module module = moduleDao.save(new Module("module" + i, i, new HashSet<User>()));
			modules.add(module);
		}
		for (int j = 1; j < 4; j++) {
			User user = new User("user" + j, modules);
			userDao.save(user);
		}
//		User user = new User("user1", modules);
//		userDao.save(user);

	}

}
