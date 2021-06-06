package com.coding.assignment.codingassignmentbackend.services;

import com.coding.assignment.codingassignmentbackend.domains.ContactRequest;
import com.coding.assignment.codingassignmentbackend.dtos.ContactRequestDto;
import com.coding.assignment.codingassignmentbackend.dtos.ContactResponseDto;
import com.coding.assignment.codingassignmentbackend.repositories.ContactRequestRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.Reader;
import java.util.Date;


@Service
public class CSVReadingService {

    private final ContactRequestRepository contactRequestRepository;

    public CSVReadingService(ContactRequestRepository contactRequestRepository) {
        this.contactRequestRepository = contactRequestRepository;
    }

    public ContactResponseDto getPhoneNumber(ContactRequestDto requestDto) {
        String tell = null;
        try {
            String CSV_FILE_PATH = "csv/sample-csv.csv";
//            String CSV_FILE_PATH = "C:\\Users\\Pc\\Documents\\csv\\sample-csv.csv";
            Reader in = new FileReader(CSV_FILE_PATH);
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
            for (CSVRecord record : records) {
                String name = record.get("name");
                String contact = record.get("contact");
                if (requestDto.getRequestName().equals(name)) {
                    tell = contact;
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        contactRequestRepository.save(
                new ContactRequest()
                        .setRequestName(requestDto.getRequestName())
                        .setDeviceName(requestDto.getDeviceName())
                        .setUserName(requestDto.getUserName())
                        .setFound(tell != null)
                        .setRequestedAt(new Date())
                        .setResult(tell)
        );
        return new ContactResponseDto().setContact(tell).setName(requestDto.getRequestName());
    }


}
