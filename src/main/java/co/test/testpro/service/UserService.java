package co.test.testpro.service;

import co.test.testpro.domain.authority;
import co.test.testpro.dto.UserDto;
import co.test.testpro.repository.UserRepository;
import co.test.testpro.util.SecurityUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) { //UserRepository , PassWordEncoder를 주입받습니다.
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User signup(UserDto userDto) { //회원가입 로직을 수행하는 메소드입니다.
        if (userRepository.findOneWithAuthoritiesByUsername(userDto.getUsername()).orElse(null) != null) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }

        //빌더 패턴의 장점
        authority auth = authority.builder() //권한 정보 주입
                .authorityName("ROLE_USER")
                .build();

        User user = User.builder() //유저 정보 생성
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .nickname(userDto.getNickname())
                .authorities(Collections.singleton(auth))
                .activated(true)
                .build();

        return userRepository.save(user); //save 메소드 실행
    }

    @Transactional(readOnly = true)
    public Optional<User> getUserWithAuthorities(String username) { //파람으로 username을 기준으로 정보를 가져오고
        return userRepository.findOneWithAuthoritiesByUsername(username);
    }

    @Transactional(readOnly = true)
    public Optional<User> getMyUserWithAuthorities() { //securityContext에 저장된 username의 정보만 가져옵니다.
        return SecurityUtil.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByUsername);
    }
}