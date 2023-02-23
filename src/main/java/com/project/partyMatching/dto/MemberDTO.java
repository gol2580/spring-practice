package com.project.partyMatching.dto;

public class MemberDTO {

    private String ID;
    private String PW;
    private String server;
    private int level;
    private int status;
    private int force;

    private int party_L;
    private int party_De;
    private int party_Du;
    private int party_W;
    private int party_H;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPW() {
        return PW;
    }

    public void setPW(String password) {
        this.PW = password;
    }


}
