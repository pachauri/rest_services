package com.rest.data;

import java.io.Serializable;


public class WynkObject implements Serializable {

    private String name;
    private Long createdAt;
    private String streamUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public String getStreamUrl() {
        return streamUrl;
    }

    public void setStreamUrl(String streamUrl) {
        this.streamUrl = streamUrl;
    }

    @Override
    public String toString() {
        return "WynkObject{" +
                "name='" + name + '\'' +
                ", createdAt=" + createdAt +
                ", streamUrl='" + streamUrl + '\'' +
                '}';
    }
}
