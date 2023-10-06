package com.thanhch.request;

import lombok.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author thanhch
 * <p>
 * Date: 12/03/2023
 * <p>
 * Class: CalendarRequest
 */
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class CalendarRequest {
    private String nameEvent;
    private String description;
    private Timestamp startEventTime;
    private Timestamp endEventTime;
    private List<String> emailAttendList;
}
