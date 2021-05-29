package com.coding.assignment.codingassignmentbackend.controllers;

import com.coding.assignment.codingassignmentbackend.dtos.ContactRequestDto;
import com.coding.assignment.codingassignmentbackend.dtos.ContactResponseDto;
import com.coding.assignment.codingassignmentbackend.services.CSVReadingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api")
public class MainController {

    private final CSVReadingService csvReadingService;

    public MainController(CSVReadingService csvReadingService) {
        this.csvReadingService = csvReadingService;
    }

    @PostMapping(value = "getPhoneNumber")
    public ResponseEntity<ContactResponseDto> getPhoneNumber(@RequestBody final ContactRequestDto contactRequest){
        ContactResponseDto contactResponse = csvReadingService.getPhoneNumber(contactRequest);
        return  new ResponseEntity<>(contactResponse, HttpStatus.OK);
    }
}
