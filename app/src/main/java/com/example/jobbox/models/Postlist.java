package com.example.jobbox.models;

public class Postlist {
    String head, loc,sal,lang,exp;

    public Postlist(String head, String loc, String sal, String lang, String exp) {
        this.head = head;
        this.loc = loc;
        this.sal = sal;
        this.lang = lang;
        this.exp = exp;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }
}

