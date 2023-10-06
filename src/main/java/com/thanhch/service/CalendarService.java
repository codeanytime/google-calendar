package com.thanhch.service;

import com.thanhch.request.CalendarRequest;
import com.thanhch.response.CalendarResponse;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * @author thanhch
 * <p>
 * createdDate: 12/03/2023
 * Interface CalendarService
 */
public interface CalendarService {
    CalendarResponse addEvent(CalendarRequest request) throws GeneralSecurityException, IOException;
}
