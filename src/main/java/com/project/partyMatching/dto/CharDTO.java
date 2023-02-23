package com.project.partyMatching.dto;

public class CharDTO {
    private String ID;
    private String nickname;

    private String server;
    private int level;
    private int status;
    private int force;

    private int party_L;
    private int party_De;
    private int party_Du;
    private int party_W;
    private int party_H;

    public String getID() {return ID;}
    public void setID(String ID) {this.ID = ID;}

    public String getNickname() {return nickname;}
    public void setNickname(String nickname) {this.nickname = nickname;}

    public int getLevel() {return level;}
    public void setLevel(int level) {this.level = level;}
    public int getForce() {return force;}
    public void setForce(int force) {this.force = force;}
    public String getServer() {return server;}
    public void setServer(String server) {this.server = server;}
    public int getStatus() {return status;}
    public void setStatus(int status) {this.status = status;}
}
