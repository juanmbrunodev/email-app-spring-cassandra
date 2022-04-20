package com.jmb.email;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.jmb.email.dictionaries.Folders;
import com.jmb.email.model.EmailListItem;
import com.jmb.email.model.key.EmailListItemKey;
import com.jmb.email.persistence.EmailListItemRepository;
import com.jmb.email.persistence.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
@RestController
public class EmailApplication {

	@Autowired
	FolderRepository folderRepository;

	@Autowired
	EmailListItemRepository emailListItemRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmailApplication.class, args);
	}

  @PostConstruct
  public void init() {
    /* Initial versions persists these to Cassandra until adding entities functionalities are done.
    Uncomment to have the code below do that */
    //		folderRepository.save(new Folder("juanmbrunodev", "Coding", "Blue"));
    //		folderRepository.save(new Folder("juanmbrunodev", "Testing", "Green"));
    //		folderRepository.save(new Folder("juanmbrunodev", "Feeds", "Yellow"));

    /* Seeds some email items linked to folder of user above */
//    for (int i = 0; i < 10; i++) {
//      EmailListItemKey key =
//          new EmailListItemKey("juanmbrunodev", Folders.INBOX.getName(), Uuids.timeBased());
//		EmailListItem item = new EmailListItem();
//		item.setKey(key);
//		item.setTo(Arrays.asList("juanmbrunodev@email-app.com"));
//		item.setSubject("Subject Number " + i);
//		item.setRead(false);
//		emailListItemRepository.save(item);
//    }
  }
}
