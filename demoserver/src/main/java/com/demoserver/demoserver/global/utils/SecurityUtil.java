package com.demoserver.demoserver.global.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.demoserver.demoserver.status.auth.UnauthorizedTokenException;

/**
 * SecurityUtil은 API 호출 시, Member의 정보가 헤더에 담겨져 올텐데, 어떤 Member가 API를 요청했는지 조회하는
 * 코드가 담겨있음
 * SecurityUtil.getCurrentMemberId() 코드를 사용하면 편리하게 현재 memberId를 조회할 수 있습니다.
 * 
 * @author rimsong
 */
public class SecurityUtil {
    public static String getCurrentUserEmail() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getName() == null) {
            throw new UnauthorizedTokenException("Unauthorized Token");
        }
        return authentication.getName();
    }
}