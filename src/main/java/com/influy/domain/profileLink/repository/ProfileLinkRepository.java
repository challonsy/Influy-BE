package com.influy.domain.profileLink.repository;

import com.influy.domain.profileLink.entity.ProfileLink;
import com.influy.domain.seller.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileLinkRepository extends JpaRepository<ProfileLink, Long> {
    List<ProfileLink> findBySeller(Seller seller);

    List<ProfileLink> findAllBySellerOrderByCreatedAt(Seller seller);

    Integer countBySeller(Seller seller);
}
