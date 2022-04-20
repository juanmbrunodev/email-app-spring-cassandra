package com.jmb.email.model.key;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.util.UUID;

@Data
@AllArgsConstructor
@PrimaryKeyClass
public class EmailListItemKey {

    @PrimaryKeyColumn(name = "user_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String userId;

    @PrimaryKeyColumn(name = "label", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private String label;

    /* Time is embedded into this UUID, when cassandra Uuid.timeBased() method is used and can be
    * actually retrieved later as a time representation */
    @PrimaryKeyColumn(name = "created_time_UUID", ordinal = 2, type = PrimaryKeyType.CLUSTERED)
    private UUID timeUUID;
}
