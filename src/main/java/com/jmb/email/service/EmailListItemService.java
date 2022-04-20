package com.jmb.email.service;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.jmb.email.model.EmailListItem;
import com.jmb.email.persistence.EmailListItemRepository;
import com.jmb.email.utils.TimeDateUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmailListItemService {

    private EmailListItemRepository emailListItemRepository;

    public List<EmailListItem> findEmailItemsByUserIdAndFolder(String userId, String label) {
    List<EmailListItem> emailItems =
        emailListItemRepository.findAllByKey_userIdAndKey_label(userId, label);
    // The items (Model objects) are enriched with a Transient property, this could also be mapped
    // to a DTO (i.e: with libraries like AutoMapper)
        // A good read: https://stackoverflow.com/questions/21554977/should-services-always-return-dtos-or-can-they-also-return-domain-models
    emailItems.forEach(
        emailListItem -> {
          long ts = Uuids.unixTimestamp(emailListItem.getKey().getTimeUUID());
          emailListItem.setTimeAgoString(TimeDateUtil.convertTimestampToTimeAgo(ts));
        });
        return emailItems;
    }
}
