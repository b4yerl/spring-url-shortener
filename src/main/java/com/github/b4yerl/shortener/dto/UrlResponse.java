package com.github.b4yerl.shortener.dto;

public class UrlResponse {
    private boolean success;
    private int status;
    private String shortUrl;
    private String originalUrl;

    public UrlResponse(boolean success, int status, String shortUrl, String originalUrl) {
        this.success = success;
        this.status = status;
        this.shortUrl = shortUrl;
        this.originalUrl = originalUrl;
    }

    public UrlResponse() {
    }

    public boolean isSuccessful() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
}
