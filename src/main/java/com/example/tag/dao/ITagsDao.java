package com.example.tag.dao;

import com.example.tag.model.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITagsDao extends JpaRepository<Tags, Integer> {
}
