package com.project.partyMatching.dto;

public class SpecDTO {
    private String leaderName;
    private String bossName;
    private int numOfChar;
    private String sserver;
    private int minLevel;
    private int minStatus;
    private int minForce;

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public int getNumOfChar() {
        return numOfChar;
    }

    public void setNumOfChar(int numOfChar) {
        this.numOfChar = numOfChar;
    }

    public String getBossName() {
        return bossName;
    }

    public void setBossName(String bossName) {
        this.bossName = bossName;
    }

    public String getSserver() {
        return sserver;
    }

    public void setSserver(String sserver) {
        this.sserver = sserver;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(int minLevel) {
        this.minLevel = minLevel;
    }

    public int getMinStatus() {
        return minStatus;
    }

    public void setMinStatus(int minStatus) {
        this.minStatus = minStatus;
    }

    public int getMinForce() {
        return minForce;
    }

    public void setMinForce(int minForce) {
        this.minForce = minForce;
    }
}
