package com.project.partyMatching.dto;

public class MemberDTO {

    private String id;
    private String password;
    private String server;
    private int level;
    private int status;
    private int force;

    private int party_L;
    private int party_De;
    private int party_Du;
    private int party_W;
    private int party_H;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
