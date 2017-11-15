package com.rest.controller;

import com.rest.data.WynkObject;
import com.rest.service.YouTubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/playlistitems")
public class WynkController {

    @Autowired
    private YouTubeService youTubeService;

    @RequestMapping(method = RequestMethod.GET)
    public WynkObject getPlayList() {
        try {
            return youTubeService.getPlayListByPlayListId();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}




