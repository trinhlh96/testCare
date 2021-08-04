package com.example.care.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Complain {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        @JoinColumn(name = "departmentId")
        @JsonBackReference
        private Department department;
        @Column(insertable = false, updatable = false)
        private Long departmentId;
        private String ticketId;
        private String phone;
        private String opinion;
        private String solving;
        private Date createdAt;
        private Date processingTime;
        private boolean status;
}
