package com.thanhch.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * @author thanhch
 * <p>
 * Date: 13/03/2023
 * <p>
 * Class: ChatOpsRequest
 */
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @Builder
@EqualsAndHashCode @ToString
public class ChatOpsRequest {
    @NonNull
    private String message;

    @JsonProperty("channel_id")
    @NonNull
    private String channelId;

    @JsonProperty("user_id")
    @NonNull
    private String userId;
}
