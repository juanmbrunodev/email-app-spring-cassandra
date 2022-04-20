package com.jmb.email.controller;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.jmb.email.dictionaries.Folders;
import com.jmb.email.dictionaries.Pages;
import com.jmb.email.model.EmailListItem;
import com.jmb.email.model.Folder;
import com.jmb.email.service.EmailListItemService;
import com.jmb.email.service.FolderService;
import com.jmb.email.utils.TimeDateUtil;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class InboxController {

  private FolderService folderService;
  private EmailListItemService emailListItemService;

  @GetMapping("/")
  public String home(@AuthenticationPrincipal OAuth2User authenticatedPrincipal, Model model) {

    // Send to index login page if not authenticated
    if (validateLoginState(authenticatedPrincipal)) return Pages.HOME.getPage();

    //Fetch Folders - Login ID is the ID from the Github Oauth2 login
    retrieveUserFolders(authenticatedPrincipal, model);

    // Fetch Email items per user and folder label - The default folder to load initially should be:
    // INBOX
    // Later this will be a query parameter on a request, based on an user clicking a folder action
    retrieveEmailItemsForFolder(
        authenticatedPrincipal.getAttribute("login"), Folders.INBOX.getName(), model);

    return Pages.INBOX_FOLDERS.getPage();

  }

  private void retrieveUserFolders(OAuth2User authenticatedPrincipal, Model model) {
    String userId = authenticatedPrincipal.getAttribute("login");
    List<Folder> userFolders = folderService.findFoldersByUserId(userId);
    model.addAttribute("defaultFolders", folderService.defaultFolders(userId));
    model.addAttribute("userFolders", userFolders);
  }

  private boolean validateLoginState(OAuth2User authenticatedPrincipal) {
    return (Objects.isNull(authenticatedPrincipal)
        || !StringUtils.hasText(authenticatedPrincipal.getAttribute("name")));
  }

  //TODO: This to be refactored into an appropriate service
  private void retrieveEmailItemsForFolder(String userId, String folderLabel, Model model) {
    List<EmailListItem> emailItems =
        emailListItemService.findEmailItemsByUserIdAndFolder(userId, folderLabel);
    model.addAttribute("emailItems", emailItems);
  }
}
