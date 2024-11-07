package com.sparta.project.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Getter
@MappedSuperclass
public class BaseEntity {
    @Column(name="is_deleted") // 삭제 여부
    @ColumnDefault("false")
    private Boolean isDeleted;

    @CreatedDate
    @Column(name="created_at", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @Column(name="deleted_at")
    private LocalDateTime deletedAt;

    @Column(name="created_by", length=10, updatable = false)
    private String createdBy;

    @LastModifiedDate
    @Column(name="updated_by", length=10)
    private LocalDateTime updatedBy;

    @Column(name="deleted_by", length=10)
    private LocalDateTime deletedBy;
}