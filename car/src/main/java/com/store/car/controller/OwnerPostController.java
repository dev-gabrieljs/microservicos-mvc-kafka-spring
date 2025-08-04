package com.store.car.controller;

import com.store.car.dto.CarPostDTO;
import com.store.car.dto.OwnerPostDTO;
import com.store.car.service.OwnerPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class OwnerPostController {

    @Autowired
    private OwnerPostService ownerPostService;

    @PostMapping
    public ResponseEntity<CarPostDTO> createOwner(@RequestBody OwnerPostDTO ownerPostDTO) {
        ownerPostService.createOwnerPost(ownerPostDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OwnerPostDTO>> getAllOwners() {
        List<OwnerPostDTO> owners = ownerPostService.getAllOwners();
        return ResponseEntity.ok(owners);
    }
}
