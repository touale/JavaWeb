package cn.touale.cula.entity;

/**
 * @author Touale
 * @description News
 * @date 2021/12/30 13:57
 */

public class News {

    private long nid;
    private long ntid;
    private String ntitle;
    private String nauthor;
    private java.sql.Timestamp ncreatedate;
    private String npicpath;
    private String ncontent;
    private java.sql.Timestamp nmodifydate;
    private String nsummary;


    public long getNid() {
        return nid;
    }

    public void setNid(long nid) {
        this.nid = nid;
    }


    public long getNtid() {
        return ntid;
    }

    public void setNtid(long ntid) {
        this.ntid = ntid;
    }


    public String getNtitle() {
        return ntitle;
    }

    public void setNtitle(String ntitle) {
        this.ntitle = ntitle;
    }


    public String getNauthor() {
        return nauthor;
    }

    public void setNauthor(String nauthor) {
        this.nauthor = nauthor;
    }


    public java.sql.Timestamp getNcreatedate() {
        return ncreatedate;
    }

    public void setNcreatedate(java.sql.Timestamp ncreatedate) {
        this.ncreatedate = ncreatedate;
    }


    public String getNpicpath() {
        return npicpath;
    }

    public void setNpicpath(String npicpath) {
        this.npicpath = npicpath;
    }


    public String getNcontent() {
        return ncontent;
    }

    public void setNcontent(String ncontent) {
        this.ncontent = ncontent;
    }


    public java.sql.Timestamp getNmodifydate() {
        return nmodifydate;
    }

    public void setNmodifydate(java.sql.Timestamp nmodifydate) {
        this.nmodifydate = nmodifydate;
    }


    public String getNsummary() {
        return nsummary;
    }

    public void setNsummary(String nsummary) {
        this.nsummary = nsummary;
    }

}
