package com.jmb.email.persistence;

import com.jmb.email.model.EmailListItem;
import com.jmb.email.model.key.EmailListItemKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailListItemRepository extends CassandraRepository<EmailListItem, EmailListItemKey> {

    /* This ties to the PrimaryKeyClass annotated, that works as Cassandra composite key for the entity.
    * Because the Key embedded object is named key, and holds below two properties, Spring JPA acts based
    * on its opinionated nature (convention) and finds the records */
    List<EmailListItem> findAllByKey_userIdAndKey_label(String userId, String label);
}
