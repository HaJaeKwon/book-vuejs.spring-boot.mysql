package com.taskagile.web.apis.authenticate;

import com.taskagile.utils.JsonUtils;
import com.taskagile.web.results.ApiResult;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SimpleLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setStatus(HttpStatus.OK.value());
        // 로그아웃 성공 결과를 JSON 으로 내보낸다.
        JsonUtils.write(response.getWriter(), ApiResult.message("logged-out"));
    }
}
