package com.jbc.zipcodelookup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/zipcode")
public class ZipCodeController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    ZipCodeRepo repository;

    public ZipCodeController(ZipCodeRepo repository) {
        this.repository = repository;
    }

    @GetMapping
    public Iterable<ZipCode> getZIPCodes() {
        return repository.findAll();
    }

    @GetMapping("/{zipcode}")
    public ZipCode getZIPCode(@PathVariable String zipcode) {
        Optional<ZipCode> result = repository.findById(zipcode);
        return result.orElse(null);
    }
}
