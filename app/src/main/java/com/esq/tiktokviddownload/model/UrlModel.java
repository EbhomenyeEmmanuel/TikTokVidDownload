package com.esq.tiktokviddownload.model;

public class UrlModel {
    private String url;

    public UrlModel(String url) {
        this.url = url;
    }

    public UrlModel() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isValidTikTokUrl(){
        return true;
    }

}
