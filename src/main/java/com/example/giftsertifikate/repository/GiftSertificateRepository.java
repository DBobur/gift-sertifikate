package com.example.giftsertifikate.repository;

import com.example.giftsertifikate.entity.GiftSertificate;
import com.example.giftsertifikate.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public interface GiftSertificateRepository extends JpaRepository<GiftSertificate, UUID> {
    Page<GiftSertificate> findByTagsName(String tag, Pageable pageable);
    Page<GiftSertificate> findAllByNameContains(String name, Pageable pageable);
    Page<GiftSertificate> findAllByDescriptionContains(String description, Pageable pageable);


}
