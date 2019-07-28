package com.pengyuan.backstage.bean;

/**
 * @author LX
 * @date 2019/7/25 - 19:59
 */
public class ProcedureHotKey {

    private String pid;
    private String pName;

    public ProcedureHotKey(String pid, String pName) {
        this.pid = pid;
        this.pName = pName;
    }

    @Override
    public String toString() {
        return "ProcedureHotKey{" +
                "pid='" + pid + '\'' +
                ", pName='" + pName + '\'' +
                '}';
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }
}
