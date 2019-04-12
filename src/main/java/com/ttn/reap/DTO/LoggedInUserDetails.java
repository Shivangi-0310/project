package com.ttn.reap.DTO;

public class LoggedInUserDetails {
    private Integer id;
    private String firstName;
    private String lastName;
    private String profilePhoto;
    private String email;
    private Integer goldBadgeCount;
    private Integer silverBadgeCount;
    private Integer bronzeBadgeCount;
    private Integer noOfGoldBadgeEarned;
    private Integer noOfSilverBadgeEarned;
    private Integer noOfBronzeBadgeEarned;
    private Integer points;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoggedInUserDetails{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", profilePhoto='" + profilePhoto + '\'' +
                ", email='" + email + '\'' +
                ", goldBadgeCount=" + goldBadgeCount +
                ", silverBadgeCount=" + silverBadgeCount +
                ", bronzeBadgeCount=" + bronzeBadgeCount +
                ", noOfGoldBadgeEarned=" + noOfGoldBadgeEarned +
                ", noOfSilverBadgeEarned=" + noOfSilverBadgeEarned +
                ", noOfBronzeBadgeEarned=" + noOfBronzeBadgeEarned +
                ", points=" + points +
                '}';
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

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public LoggedInUserDetails() {
    }

    public void setAllBadges(Integer goldBadgeCount,Integer silverBadgeCount,
                             Integer bronzeBadgeCount, Integer noOfGoldBadgeEarned,
                             Integer noOfSilverBadgeEarned, Integer noOfBronzeBadgeEarned){
        this.setGoldBadgeCount(goldBadgeCount);
        this.setSilverBadgeCount(silverBadgeCount);
        this.setBronzeBadgeCount(bronzeBadgeCount);
        this.setNoOfGoldBadgeEarned(noOfGoldBadgeEarned);
        this.setNoOfSilverBadgeEarned(noOfSilverBadgeEarned);
        this.setNoOfBronzeBadgeEarned(noOfBronzeBadgeEarned);
    }

}

