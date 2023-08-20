package com.example.daointerface;

import com.example.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITagsDao extends JpaRepository<Tag, Integer> {
}
