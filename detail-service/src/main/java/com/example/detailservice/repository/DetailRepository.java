package com.example.detailservice.repository;

import com.example.detailservice.model.CreateDetail;
import com.example.detailservice.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Long> {
}
