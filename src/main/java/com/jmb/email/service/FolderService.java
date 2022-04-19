package com.jmb.email.service;

import com.jmb.email.dictionaries.Folders;
import com.jmb.email.model.Folder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


/**
 * Service for all folder related, business logic operations.
 *
 * @author JuanMBruno.
 */
@Service
public class FolderService {

  public List<Folder> defaultFolders(String userId) {
    return Arrays.asList(
        new Folder(userId, Folders.INBOX.getName(), Folders.INBOX.getColor()),
        new Folder(userId, Folders.SENT.getName(), Folders.SENT.getColor()),
        new Folder(userId, Folders.IMPORTANT.getName(), Folders.IMPORTANT.getColor()));
  }

}

