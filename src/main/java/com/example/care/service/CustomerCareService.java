package com.example.care.service;

import com.example.care.entity.Account;
import com.example.care.entity.Complain;
import com.example.care.entity.Department;
import com.example.care.repository.AccountRepository;
import com.example.care.repository.ComplainRepository;
import com.example.care.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CustomerCareService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private ComplainRepository complainRepository;

    public Date setDateTimeNow() {
        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return sqlDate;
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Department createDeprecated(Department department) {

        department.setCreatedAt(setDateTimeNow());
        return departmentRepository.save(department);
    }

    public Department editDeprecated(Long id, Department updateDepartment) {
        Optional<Department> editDep = departmentRepository.findById(id);
        if (editDep.isPresent()) {
            Department department = editDep.get();
            department.setName(updateDepartment.getName());
            department.setStatus(updateDepartment.getStatus());
            return departmentRepository.save(department);
        } else {
            return null;
        }
    }

    public String deleteDeprecated(Long id) {
        Optional<Department> editDep = departmentRepository.findById(id);
        if (editDep.isPresent()) {
            departmentRepository.deleteById(id);
            return "Thành công";
        }
        return "Thất bại";
    }

    public String random() {
        Random rand = new Random();
        return String.valueOf(rand.nextInt(10000000));
    }


    public Complain createComplain(Complain complain) {
        complain.setCreatedAt(setDateTimeNow());
        complain.setTicketId(random());
        complain.setProcessingTime(setDateTimeNow());
        return complainRepository.save(complain);
    }

    public List<Complain> listAllComplain() {
       return complainRepository.findAll();
    }
    public List<Department> listAllDepartment() {
        return departmentRepository.findAll();
    }

    public List<Complain> findTicketOrPhone(String ticket, String phone){
        return complainRepository.findAllByTicketIdOrPhone(ticket, phone);
    }



}
