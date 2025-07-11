package com.influy.global.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Value("${social.redirect-uri}")
    private String redirectUri;
    @Bean
    public OpenAPI InfluyAPI() {
        Info info = new Info()
                .title("INFLUY API")
                .description("""
                        ### INFLUY API 명세 문서입니다.
                        - #### API 관련 버그 및 수정 소요, 제안 등이 있다면 <a href="https://github.com/INFLUY/Influy-BE">BE 깃허브</a> 이슈에 등록해주시면 감사하겠습니다.
                        """+
                        "- #### 카카오 로그인 url: https://kauth.kakao.com/oauth/authorize?client_id=a208249d69627b4ccffff588db18bcb9&redirect_uri="+redirectUri+"&response_type=code")
                .version("1.0.0");

        String jwtSchemeName = "JWT TOKEN";
        // API 요청헤더에 인증정보 포함
        SecurityRequirement securityRequirement = new SecurityRequirement().addList(jwtSchemeName);
        // SecuritySchemes 등록
        Components components = new Components()
                .addSecuritySchemes(jwtSchemeName, new SecurityScheme()
                        .name(jwtSchemeName)
                        .type(SecurityScheme.Type.HTTP) // HTTP 방식
                        .scheme("bearer")
                        .bearerFormat("JWT"));

        return new OpenAPI()
                .addServersItem(new Server().url("/"))
                .info(info)
                .addSecurityItem(securityRequirement)
                .components(components);
    }
}

