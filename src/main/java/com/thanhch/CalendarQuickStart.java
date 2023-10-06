package com.thanhch;

import com.thanhch.request.CalendarRequest;
import com.thanhch.service.CalendarService;
import com.thanhch.service.ChatOpsService;
import com.thanhch.service.impl.CalendarServiceImpl;
import com.thanhch.service.impl.ChatOpsServiceImpl;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.Timestamp;
import java.util.Collections;

/* class to test */
class CalendarQuickstart {
    public static void main(String... args) throws IOException, GeneralSecurityException {
        CalendarService insert = new CalendarServiceImpl();
        CalendarRequest request = new CalendarRequest("Phong van ung vien",
                "https://docs.google.com/document/d/1UjIbjqsEYWHb6PL_CFPhxcxbnIcr2qvijJ8rMpmxpvs/edit",
                Timestamp.valueOf("2023-08-21 14:30:53.269309"),
                Timestamp.valueOf("2023-08-21 15:30:53.269309"),
                Collections.singletonList("thanhch@nal.vn"));

        insert.addEvent(request);
        ChatOpsService chatOpsService = new ChatOpsServiceImpl();
        chatOpsService.createPost("test 123", Collections.singletonList("thanhch"));
    }
}
