package com.ttn.reap.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ttn.reap.enums.Role;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIgnoreProperties(value = {"password", "confirmPassword", "isActive"})
@NamedNativeQuery(name = "Employee.findBynameNamedNative", query = "select * from Employee where firstName= :name OR lastName= :name", resultClass = Employee.class)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "First Name field is empty!")
    @Size(min = 2, message = "First Name should have at least 2 characters")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last name field is empty!")
    @Size(min = 2, message = "Last Name should have at least 2 characters")
    @Column(name = "last_name")
    private String lastName;

    String profilePhoto;

    @NotBlank(message = "Email field is empty!")
    @Email(message = "Enter valid Email-Id")
    private String email;

    @NotBlank
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Enter a valid contact no")
    @Column(name = "contact_number")
    private String contactNumber;

    @NotBlank
    @Size(min = 3, max = 20, message = "Password should be at least 3 characters in length")
    private String password;

    @Transient
    private String confirmPassword;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "reset_token")
    private String resetToken;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    private Boolean isActive;

    private Integer goldBadgeCount;
    private Integer silverBadgeCount;
    private Integer bronzeBadgeCount;

    private Integer noOfGoldBadgeEarned;
    private Integer noOfSilverBadgeEarned;
    private Integer noOfBronzeBadgeEarned;
    private Integer points = 0;

    @ElementCollection
// @Enumerated(EnumType.STRING)
    private Set<Role> roleSet = new HashSet<>();

    public Employee() {
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Integer getGoldBadgeCount() {
        return goldBadgeCount;
    }

    public void setGoldBadgeCount(Integer goldBadgeCount) {
        this.goldBadgeCount = goldBadgeCount;
    }

    public Integer getSilverBadgeCount() {
        return silverBadgeCount;
    }

    public void setSilverBadgeCount(Integer silverBadgeCount) {
        this.silverBadgeCount = silverBadgeCount;
    }

    public Integer getBronzeBadgeCount() {
        return bronzeBadgeCount;
    }

    public void setBronzeBadgeCount(Integer bronzeBadgeCount) {
        this.bronzeBadgeCount = bronzeBadgeCount;
    }

    public Integer getNoOfGoldBadgeEarned() {
        return noOfGoldBadgeEarned;
    }

    public void setNoOfGoldBadgeEarned(Integer noOfGoldBadgeEarned) {
        this.noOfGoldBadgeEarned = noOfGoldBadgeEarned;
    }

    public Integer getNoOfSilverBadgeEarned() {
        return noOfSilverBadgeEarned;
    }

    public void setNoOfSilverBadgeEarned(Integer noOfSilverBadgeEarned) {
        this.noOfSilverBadgeEarned = noOfSilverBadgeEarned;
    }

    public Integer getNoOfBronzeBadgeEarned() {
        return noOfBronzeBadgeEarned;
    }

    public void setNoOfBronzeBadgeEarned(Integer noOfBronzeBadgeEarned) {
        this.noOfBronzeBadgeEarned = noOfBronzeBadgeEarned;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }
}