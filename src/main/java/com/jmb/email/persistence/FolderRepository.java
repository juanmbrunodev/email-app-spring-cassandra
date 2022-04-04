package com.jmb.email.persistence;

import com.jmb.email.model.Folder;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FolderRepository extends CassandraRepository<Folder, String> {

    List<Folder> findAllByUserId(String userId);
}
