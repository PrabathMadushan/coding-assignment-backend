package com.coding.assignment.codingassignmentbackend.repositories;

import com.coding.assignment.codingassignmentbackend.domains.ContactRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRequestRepository extends JpaRepository<ContactRequest,Integer> {
}
