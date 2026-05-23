package com.ubutua.seller_api.services;

import com.ubutua.seller_api.models.Seller;
import com.ubutua.seller_api.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public Seller getById(long id){
        Seller seller = sellerRepository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Seller not found"));
        return seller;
    }

    public List<Seller> getAll() {
        return sellerRepository.findAll();
    }

    public Seller save(Seller seller) {
        return sellerRepository.save(seller);
    }

    public void deleteById(long id) {
        Seller seller = getById(id);
        sellerRepository.delete(seller);
    }

    public void update(long id, Seller sellerUpdate) {
        Seller seller = getById(id);

        seller.setName(sellerUpdate.getName());
        seller.setSalary(sellerUpdate.getSalary());
        seller.setBonus(sellerUpdate.getBonus());
        seller.setGender(sellerUpdate.getGender());

        sellerRepository.save(seller);
    }

}
