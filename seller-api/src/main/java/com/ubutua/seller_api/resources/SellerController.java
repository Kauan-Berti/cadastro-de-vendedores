package com.ubutua.seller_api.resources;

import com.ubutua.seller_api.dto.SellerRequest;
import com.ubutua.seller_api.dto.SellerResponse;
import com.ubutua.seller_api.services.SellerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    public ResponseEntity<SellerResponse> save(@Validated @RequestBody SellerRequest sellerRequest) {
        SellerResponse sellerResponse = sellerService.save(sellerRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(sellerResponse.getId())
                .toUri();

        return ResponseEntity.created(location).body(sellerResponse);
    }

    @GetMapping("{id}")
    public ResponseEntity<SellerResponse> getSeller(@PathVariable long id) {
        SellerResponse sellerResponse = sellerService.getById(id);
        return ResponseEntity.ok(sellerResponse);
    }

    @GetMapping
    public ResponseEntity<List<SellerResponse>> getSellers() {
        return ResponseEntity.ok(sellerService.getAll());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> removeSeller(@PathVariable long id) {
        sellerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateSeller(@PathVariable long id,@Valid @RequestBody SellerRequest sellerUpdate) {
        sellerService.update(id, sellerUpdate);
        return ResponseEntity.ok().build();
    }
}
