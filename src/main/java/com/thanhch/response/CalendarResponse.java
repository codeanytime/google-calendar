package com.thanhch.response;

import lombok.*;

/**
 * @author thanhch
 * <p>
 * Date: 12/03/2023
 * <p>
 * Class: CalendarResponse
 */
@NoArgsConstructor @AllArgsConstructor
@Builder
@Setter @Getter @ToString
public class CalendarResponse {
    private String eventLink;
    private String meetingLink;
    private String status;
}
