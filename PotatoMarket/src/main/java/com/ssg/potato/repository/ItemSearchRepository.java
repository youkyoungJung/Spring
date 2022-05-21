package com.ssg.potato.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ssg.potato.domain.ItemThumb;

public interface ItemSearchRepository extends JpaRepository<ItemThumb, String>{

	List<ItemThumb> findByTitleContaining(String title);
}
