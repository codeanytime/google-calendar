package com.thanhch.service.impl;

import com.thanhch.config.ChatOpsConfig;
import com.thanhch.request.ChatOpsRequest;
import com.thanhch.service.ChatOpsService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author thanhch
 * <p>
 * Date: 13/03/2023
 * <p>
 * Class: ChatOpsServiceImpl
 */
public class ChatOpsServiceImpl implements ChatOpsService {
    @Override
    public void createPost(String content, List<String> tagUsers) {
        RestTemplate restTemplate = new RestTemplate();
        ChatOpsRequest request = ChatOpsRequest.builder()
                        .userId(ChatOpsConfig.USER_ID)
                                .channelId(ChatOpsConfig.CHANNEL_ID)
                                        .message(createMessageRequest(content, tagUsers))
                                                .build();
        HttpHeaders headers = new HttpHeaders();
        configHeader(headers);

        HttpEntity requestEntity = new HttpEntity(request, headers);
        restTemplate.postForObject(ChatOpsConfig.HOST_URL, requestEntity, String.class);
    }

    private void configHeader(HttpHeaders headers) {
        headers.add("Cookie", ChatOpsConfig.COOKIE);
        headers.add("X-CSRF-Token", ChatOpsConfig.X_CSRF_TOKEN);
        headers.add("X-Requested-With", ChatOpsConfig.X_REQUEST_WITH);
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    private String createMessageRequest(String content, List<String> tagUsers) {
        StringBuilder contentResult = new StringBuilder();
        tagUsers.stream().forEach(s -> {
            if (s.contains("@")) {
                contentResult.append("@").append(s, 0, s.indexOf("@")).append(" ");
            } else {
                contentResult.append("@").append(s).append(" ");
            }
        });
        contentResult.append(content);
        return contentResult.toString();
    }
}
