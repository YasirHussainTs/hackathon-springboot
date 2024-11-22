package com.yasirhussain.app.dto;

public class UserDTO {
    private Long id;
    private String name;
    private String password;
    private String contact;

    public UserDTO(Long id, String name, String password, String contact) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.contact = contact;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
