package com.thanhch.service;

import java.util.List;

/**
 * @author thanhch
 * <p>
 * createdDate: 13/03/2023
 * Interface ChatOpsService
 */
public interface ChatOpsService {
    void createPost(String content, List<String> tagUser);
}
