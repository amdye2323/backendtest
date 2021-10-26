package co.test.testpro.controller;

import co.test.testpro.dto.LoginDto;
import co.test.testpro.dto.TokenDto;
import co.test.testpro.jwt.JwtFilter;
import co.test.testpro.jwt.TokenProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class AuthController {
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    public AuthController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authorize(@Valid @RequestBody LoginDto loginDto) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken); //loadUserByUsername 메소드 실행
        SecurityContextHolder.getContext().setAuthentication(authentication);  //Authentication객체를 생성하고 그것을 securityContext에 저장하고

        String jwt = tokenProvider.createToken(authentication); //Authentication객체로 jwt token을 생성

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt); //jwt token은 response header에 넣어주고

        TokenDto to = new TokenDto(jwt);
        String token = to.getToken();
        HashMap<String,String> result = new HashMap<>();
        result.put("token",token);
        result.put("user",loginDto.getUsername());

        return new ResponseEntity<>(result, httpHeaders, HttpStatus.OK); //tokenDTo릴 이용해서 responsebody에도 넣어서 리턴
    }

}
