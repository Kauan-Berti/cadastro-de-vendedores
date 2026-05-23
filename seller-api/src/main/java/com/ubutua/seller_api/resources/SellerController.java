package com.ubutua.seller_api.resources;

import com.ubutua.seller_api.models.Seller;
import com.ubutua.seller_api.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("sellers")
public class SellerController {

    @Autowired
    private  SellerService sellerService;

    @PostMapping
    public ResponseEntity<Seller> save(@RequestBody Seller seller) {
        seller = sellerService.save(seller);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(seller.getId())
                .toUri();

        return ResponseEntity.created(location).body(seller);
    }

    @GetMapping("{id}")
    public ResponseEntity<Seller> getSeller(@PathVariable long id) {
        Seller seller = sellerService.getById(id);
        return ResponseEntity.ok(seller);
    }

    @GetMapping
    public ResponseEntity<List<Seller>> getSellers() {
        return ResponseEntity.ok(sellerService.getAll());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> removeSeller(@PathVariable long id) {
        sellerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateSeller(@PathVariable long id, @RequestBody Seller sellerUpdate) {
        sellerService.update(id, sellerUpdate);
        return ResponseEntity.ok().build();
    }
}
