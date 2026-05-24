package com.ubutua.seller_api.services;

import com.ubutua.seller_api.dto.SellerRequest;
import com.ubutua.seller_api.dto.SellerResponse;
import com.ubutua.seller_api.models.Seller;
import com.ubutua.seller_api.repositories.SellerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    public SellerResponse getById(long id) {
        Seller seller = sellerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Seller not found"));
        return seller.toDto();
    }

    public List<SellerResponse> getAll() {
        return sellerRepository.findAll()
                .stream()
                .map(s -> s.toDto())
                .collect(Collectors.toList());
    }

    public SellerResponse save(SellerRequest sellerRequest) {
        try {
            Seller newSeller = sellerRepository.save(sellerRequest.toEntity());
            return newSeller.toDto();
        } catch (DataIntegrityViolationException e) {
            throw new EntityNotFoundException("Seller not found");
        }
    }

    public void deleteById(long id) {
        try {
            sellerRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Seller not found");
        }

    }

    public void update(long id, SellerRequest sellerUpdate) {
        try {
            Seller seller = sellerRepository.getReferenceById(id);

            seller.setName(sellerUpdate.getName());
            seller.setSalary(sellerUpdate.getSalary());
            seller.setBonus(sellerUpdate.getBonus());
            seller.setGender(sellerUpdate.getGender());

            sellerRepository.save(seller);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Seller not found");
        }
    }

}
