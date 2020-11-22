package com.keeperofthevoid.flywaydemo.endpoint;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.keeperofthevoid.flywaydemo.model.Address;
import com.keeperofthevoid.flywaydemo.repository.AddressRepository;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AddressEndpoint {
    @Autowired
    private AddressRepository repository;

    @GetMapping("/addresses")
    public List<Address> getAllAddresses() {
        return repository.findAll();
    }

    @GetMapping("/addresses/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable(value = "id") Long addressId)
        throws ResourceNotFoundException {
        Address address = repository.findById(addressId)
          .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id :: " + addressId));
        return ResponseEntity.ok().body(address);
    }

    @PostMapping("/addresses")
    public Address createAddress(@Valid @RequestBody Address address) {
        return repository.save(address);
    }

    @PutMapping("/addresses/{id}")
    public ResponseEntity<Address> updateEmployee(@PathVariable(value = "id") Long addressId,
         @Valid @RequestBody Address addressDetails) throws ResourceNotFoundException {
        Address address = repository.findById(addressId)
        .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id :: " + addressId));

        address.setAddress1(addressDetails.getAddress1());
        address.setCity(addressDetails.getCity());
        address.setState(addressDetails.getState());
        address.setZip(addressDetails.getZip());
        final Address updatedAddress = repository.save(address);
        return ResponseEntity.ok(updatedAddress);
    }

    @DeleteMapping("/addresses/{id}")
    public Map<String, Boolean> deleteAddress(@PathVariable(value = "id") Long addressId)
         throws ResourceNotFoundException {
        Address address = repository.findById(addressId)
       .orElseThrow(() -> new ResourceNotFoundException("Address not found for this id :: " + addressId));

        repository.delete(address);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
