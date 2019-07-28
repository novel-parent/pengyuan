package com.pengyuan.backstage.bean;

/**
 * @author LX
 * @date 2019/7/25 - 19:59
 */
public class ProcedureHotKey {

    private Long pid;
    private String pName;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    @Override
    public String toString() {
        return "ProcedureHotKey{" +
                "pid=" + pid +
                ", pName='" + pName + '\'' +
                '}';
    }
}
