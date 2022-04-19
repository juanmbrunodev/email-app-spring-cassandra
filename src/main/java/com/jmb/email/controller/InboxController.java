package com.jmb.email.controller;

import com.jmb.email.dictionaries.Pages;
import com.jmb.email.model.Folder;
import com.jmb.email.persistence.FolderRepository;
import com.jmb.email.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;

@Controller
public class InboxController {

  //TODO: Put in constructor, for unit tests later.
  @Autowired
  private FolderRepository folderRepository;

  @Autowired
  FolderService folderService;

  @GetMapping("/")
  public String home(@AuthenticationPrincipal OAuth2User authenticatedPrincipal, Model model) {

    // Send to index login page if not authenticated
    if (Objects.isNull(authenticatedPrincipal)
        || !StringUtils.hasText(authenticatedPrincipal.getAttribute("name"))) {
      return Pages.HOME.getPage();
    }

    //Login is the ID from the Github Oauth2 login
    String userId = authenticatedPrincipal.getAttribute("login");
    List<Folder> userFolders = folderRepository.findAllByUserId(userId);
    model.addAttribute("defaultFolders", folderService.defaultFolders(userId));
    model.addAttribute("userFolders", userFolders);
    return Pages.INBOX_FOLDERS.getPage();

  }
}
