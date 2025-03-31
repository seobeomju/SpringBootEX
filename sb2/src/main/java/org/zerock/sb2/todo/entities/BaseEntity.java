package org.zerock.sb2.todo.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@Getter
@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
public abstract class BaseEntity {

    @CreatedBy
    @Column(name = "regDate", nullable = false , updatable = false)
    private LocalDateTime regDate;
    
    @LastModifiedBy
    @Column(name = "regDate", nullable = false)
    private LocalDateTime modDate;
}   
