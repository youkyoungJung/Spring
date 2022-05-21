package com.ssg.potato.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssg.potato.domain.GroupThumb;

public interface GroupSearchRepository extends JpaRepository<GroupThumb, String>{

	List<GroupThumb> findByTitleContaining(String title);
}
