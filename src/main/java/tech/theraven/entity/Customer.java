package tech.theraven.entity;

import java.time.Instant;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long created = Instant.now().getEpochSecond();

    private Long updated = Instant.now().getEpochSecond();

    @Column(name = "full_name", length = 50, nullable = false)
    @Size(min = 2, max = 50)
    private String fullName;

    @Column(length = 100, nullable = false, unique = true)
    @Size(min = 2, max = 100)
    @Email
    private String email;

    @Column(length = 14)
    @Pattern(regexp = "^\\+\\d{5,13}$")
    private String phone;

    @Column(name = "is_active", nullable = false)
    private boolean isActive = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
    
    @PreUpdate
    public void preUpdate() {
        this.updated = Instant.now().getEpochSecond();
    }
}
