package com.example.UberClone.Models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass// don't create table for auditable
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class Auditable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Pid;


    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private  Date updatedAt;


    private Long totalDistanceMeters;


    @Override
    public int hashCode() {
        return Pid==null ?0 :Pid.hashCode();
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Auditable) {
            Auditable auditableObj = (Auditable) obj;
            if (Pid == null && obj == null) return true;
            if (Pid == null || obj == null) return false;
            return Pid == ((Auditable) obj).Pid;
        } else {
          return  super.equals(obj);
        }
    }



}
