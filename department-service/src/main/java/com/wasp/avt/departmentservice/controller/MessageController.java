package com.wasp.avt.departmentservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name = "Message-Controller",
        description = "Message Controller Exposes REST APIs for Department Service"
)
@RefreshScope
@RestController
@RequestMapping("v1/messages")
public class MessageController {

    @Value("${spring.boot.message}")
    private String message;

    @GetMapping
    @Operation(
            summary = "GET Message",
            description = "Get Message Endpoint returns a message from Config-Server Repository"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "OK - Successful Operation",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(
                    responseCode = "403",
                    description = "If the current user does not have permission for this resource.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    })
    public String message() {
        return message;
    }
}
