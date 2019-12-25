package com.example.demo.entity;

public class Tpower {
    private int jid;
    private String Jname;

    public int getJid() {
        return jid;
    }

    public void setJid(int jid) {
        this.jid = jid;
    }

    public String getJname() {
        return Jname;
    }

    public void setJname(String jname) {
        Jname = jname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPagename() {
        return pagename;
    }

    public void setPagename(String pagename) {
        this.pagename = pagename;
    }

    public int getOname() {
        return oname;
    }

    public void setOname(int oname) {
        this.oname = oname;
    }

    private String address;
    private String pagename;
    private int oname;
}
