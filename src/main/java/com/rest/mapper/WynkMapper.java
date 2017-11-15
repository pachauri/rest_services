package com.rest.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.data.WynkObject;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


@Component
public class WynkMapper {
    public WynkObject getWynkObject(HashMap<String, Object> map) {
        WynkObject wynkObject = new WynkObject();
        SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-DD");
        Date date = null;
        try {
            date = df.parse(map.get("publishedAt").toString().split("T")[0]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        wynkObject.setCreatedAt(date.getTime());
        wynkObject.setName(map.get("title").toString());
        map = new ObjectMapper().convertValue(map.get("resourceId"),HashMap.class);
        wynkObject.setStreamUrl("https://www.youtube.com/watch?v="+map.get("videoId").toString());
        return wynkObject;
    }
}
