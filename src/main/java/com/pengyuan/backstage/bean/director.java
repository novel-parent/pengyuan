package com.pengyuan.backstage.bean;

/**
 * @author LX
 * @date 2019/7/7 - 15:22
 */
public class director {

    private long did;
    private long uid ;

    public long getDid() {
        return did;
    }

    public void setDid(long did) {
        this.did = did;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "director{" +
                "did=" + did +
                ", uid=" + uid +
                '}';
    }
}
