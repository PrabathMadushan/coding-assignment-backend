package com.coding.assignment.codingassignmentbackend.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class ContactRequestDto {
    private String requestName;
    private String userName;
    private String deviceName;
}
