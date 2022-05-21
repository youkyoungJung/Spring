package com.ssg.potato.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssg.potato.domain.AuctionThumb;

public interface AuctionSearchRepository extends JpaRepository<AuctionThumb, String>{

	List<AuctionThumb> findByTitleContaining(String title);
}
