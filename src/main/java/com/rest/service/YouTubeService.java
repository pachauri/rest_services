package com.rest.service;

import com.rest.data.WynkObject;

import java.io.IOException;


public interface YouTubeService {
    WynkObject getPlayListByPlayListId() throws IOException;
}
