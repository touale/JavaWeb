package cn.touale.cula.entity;


public class Comments {

    private long cid;
    private long cnid;
    private String ccontent;
    private java.sql.Timestamp cdate;
    private String cip;
    private String cauthor;


    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }


    public long getCnid() {
        return cnid;
    }

    public void setCnid(long cnid) {
        this.cnid = cnid;
    }


    public String getCcontent() {
        return ccontent;
    }

    public void setCcontent(String ccontent) {
        this.ccontent = ccontent;
    }


    public java.sql.Timestamp getCdate() {
        return cdate;
    }

    public void setCdate(java.sql.Timestamp cdate) {
        this.cdate = cdate;
    }


    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }


    public String getCauthor() {
        return cauthor;
    }

    public void setCauthor(String cauthor) {
        this.cauthor = cauthor;
    }

}
