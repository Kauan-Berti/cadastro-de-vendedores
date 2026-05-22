package com.ubutua.seller_api.repositories;


import com.ubutua.seller_api.models.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller,Long> {
}
