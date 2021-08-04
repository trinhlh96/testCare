package com.example.care.repository;

import com.example.care.entity.Account;
import com.example.care.entity.Complain;
import com.example.care.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface ComplainRepository extends JpaRepository<Complain, Long> {
    List<Complain> findAllByTicketIdOrPhone(String ticketId, String phone);

}
