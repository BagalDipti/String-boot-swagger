package com.user.user.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.catalina.Manager;




@Entity
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

	private String userName;
	
	private String userEmail;

    private Long userMobileNo;
	
	private String userDesignation;
	
	
    

    public User(int userId, String userName, String userEmail, Long userMobileNo,
            String userDesignation,Manager manager) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userMobileNo = userMobileNo;
        this.userDesignation = userDesignation;
        
    }


    public int getUserId() {
        return userId;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }


    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getUserEmail() {
        return userEmail;
    }


    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }


    public Long getUserMobileNo() {
        return userMobileNo;
    }


    public void setUserMobileNo(Long userMobileNo) {
        this.userMobileNo = userMobileNo;
    }


    public String getUserDesignation() {
        return userDesignation;
    }


    public void setUserDesignation(String userDesignation) {
        this.userDesignation = userDesignation;
    }
    
   


    public User() {
    }



	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userMobileNo="
				+ userMobileNo + ", userDesignation=" + userDesignation + "]";
	}



    



   
}
