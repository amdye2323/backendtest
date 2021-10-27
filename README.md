BackEnd TestProject
===============

#### Java Springboot Project

## Features
- [x] 서버 인증 구현(JWT)
- [x] 할 일 추가
- [x] 할 일 수정
- [x] 할 일 삭제
- [x] 할일 검색
- [x] 할일 전체검색
- [x] 할일 이미지 업로드  

### Project Stack

#### Server

- Java 8. version
- Spring boot 2.5.3 version
- mariaDB
- Docker-Compose

#### library

- Jpa
- Web
- Tomcat
- JWT-Api
- Jackson

#### Jwt Api Auth

- 현재 JWT 인증 방식 -> 로그인 발급 방식
- 인증 가입 구현 안됨
```
    /api/authenticate
    
    {
        "username" : "test",
        "password" : "test
    }
```

- 이후 Api Request 시 Header에 추가
```
    "Authorization": "Bearer " + 발급받은 jwt
```
