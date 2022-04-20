package com.jmb.email.model;

import com.jmb.email.model.key.EmailListItemKey;
import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;

@Data
@Table(value = "emails_by_user_folder")
public class EmailListItem {

    //Separate class representing the type for the repository and a composite key for the current table
    @PrimaryKey
    private EmailListItemKey key;

    @CassandraType(type = CassandraType.Name.TEXT)
    private List<String> to;

    @CassandraType(type = CassandraType.Name.TEXT)
    private String subject;

    @CassandraType(type = CassandraType.Name.BOOLEAN)
    private boolean isRead;

    @Transient
    private String timeAgoString;


}
