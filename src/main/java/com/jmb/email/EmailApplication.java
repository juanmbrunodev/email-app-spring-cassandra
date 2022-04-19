package com.jmb.email;

import com.jmb.email.model.Folder;
import com.jmb.email.persistence.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RestController
public class EmailApplication {

	@Autowired
	FolderRepository folderRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmailApplication.class, args);
	}

	@PostConstruct
	public void init() {
		/* Initial versions persists this to Cassandra until adding folder functionality is done.
		Uncomment to have the code below do that */
//		folderRepository.save(new Folder("juanmbrunodev", "Coding", "Blue"));
//		folderRepository.save(new Folder("juanmbrunodev", "Testing", "Green"));
//		folderRepository.save(new Folder("juanmbrunodev", "Feeds", "Yellow"));
	}
}
