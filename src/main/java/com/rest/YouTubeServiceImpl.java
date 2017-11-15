package com.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.data.WynkObject;
import com.rest.mapper.WynkMapper;
import com.rest.service.YouTubeService;
import com.rest.utils.WynkConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class YouTubeServiceImpl implements YouTubeService{

    @Autowired
    private WynkMapper wynkMapper;

    @Override
    public WynkObject getPlayListByPlayListId() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(WynkConstants.PLAYLIST_URL)
                .queryParam("part", "snippet")
                .queryParam("playlistId", WynkConstants.PLAYLIST_ID)
                .queryParam("key", WynkConstants.API_KEY);
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        HttpEntity<String> response = restTemplate.exchange(
                builder.build().encode().toUri(),
                HttpMethod.GET,
                entity,
                String.class);
        ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> res = objectMapper.readValue(response.getBody(), HashMap.class);
            List<HashMap<String,Object>> list =  objectMapper.convertValue(res.get("items"),List.class);
            HashMap<String,Object> map = objectMapper.convertValue(list.get(0).get("snippet"),HashMap.class);
            return  wynkMapper.getWynkObject(map);

    }
}
