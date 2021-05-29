package com.coding.assignment.codingassignmentbackend.domains;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class ContactRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String requestName;
    private boolean found;
    private String userName;
    private String deviceName;
    private Date requestedAt;
    private String result;

}
