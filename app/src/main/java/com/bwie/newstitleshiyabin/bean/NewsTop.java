package com.bwie.newstitleshiyabin.bean;



public class NewsTop {
    private String imgsrc;
    private String lmodify;
    private String title;
    private String source;
    private String url_3w;
    private String replyCount;
    private Imgextra imgextra;

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getLmodify() {
        return lmodify;
    }

    public void setLmodify(String lmodify) {
        this.lmodify = lmodify;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }



    public String getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(String replyCount) {
        this.replyCount = replyCount;
    }

    public Imgextra getImgextra() {
        return imgextra;
    }

    public void setImgextra(Imgextra imgextra) {
        this.imgextra = imgextra;
    }

    @Override
    public String toString() {
        return "NewsTop{" +
                "imgsrc='" + imgsrc + '\'' +
                ", lmodify='" + lmodify + '\'' +
                ", title='" + title + '\'' +
                ", source='" + source + '\'' +
                ", url_3w='" + url_3w + '\'' +
                ", replyCount='" + replyCount + '\'' +
                ", imgextra=" + imgextra +
                '}';
    }

    public NewsTop(String imgsrc, String lmodify, String title, String source, String url_3w, String replyCount, Imgextra imgextra) {
        this.imgsrc = imgsrc;
        this.lmodify = lmodify;
        this.title = title;
        this.source = source;
        this.url_3w = url_3w;
        this.replyCount = replyCount;
        this.imgextra = imgextra;
    }

    public String getUrl_3w() {
        return url_3w;
    }

    public void setUrl_3w(String url_3w) {
        this.url_3w = url_3w;
    }
}
