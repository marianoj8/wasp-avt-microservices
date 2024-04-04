package com.wb.departmentservice.util;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;



//@OpenAPIDefinition(
//        info = @Info(title = "WASP Logistics API - Documentation",
//                description = "Some description here",
//                version = "1.0"))
//@SecurityScheme(
//        scheme = "basic",
//        name = HEADER_STRING,
//        in = SecuritySchemeIn.HEADER,
//        type = SecuritySchemeType.APIKEY)


@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Mariano JavaSwing",
                        email = "marianojs8@yandex.ru",
                        url = "https://github.com/marianoj8"
                ),
                title = "Department Service REST API",
                description = "Department Service REST API Documentation",
                version = "1.0",
                license = @License(
                        name = "Licence name",
                        url = "https://some-url.com"
                ),
                termsOfService = "Terms of service"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "PROD ENV",
                        url = "https://wasp.com/"
                )
        },
        security = {
                @SecurityRequirement(
                        name = "bearerAuth"
                )
        }
)
//@SecurityScheme(
//        name = "bearerAuth",
//        description = "JWT auth description",
//        scheme = "bearer",
//        type = SecuritySchemeType.HTTP,
//        bearerFormat = "JWT",
//        in = SecuritySchemeIn.HEADER
//)
@SecurityScheme(
        scheme = "basic",
//        name = HEADER_STRING,
        in = SecuritySchemeIn.HEADER,
        type = SecuritySchemeType.APIKEY)
public class OpenAPIConfig {
}
