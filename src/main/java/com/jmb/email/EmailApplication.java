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
		folderRepository.save(new Folder("juanmbrunodev", "Inbox", "Blue"));
		folderRepository.save(new Folder("juanmbrunodev", "Prog", "Green"));
		folderRepository.save(new Folder("juanmbrunodev", "Sent", "Yellow"));
	}
}
