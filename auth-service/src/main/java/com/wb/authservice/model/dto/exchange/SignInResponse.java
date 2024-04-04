package com.wb.authservice.model.dto.exchange;

public record SignInResponse(String accessToken, String refreshToken) {
}
