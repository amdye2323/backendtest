package co.test.testpro.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class UserServiceIntergrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    @Commit
    public void join() throws Exception{
        //given
        User user = new User();
        user.setUsername("hello");
        //when
        Long saveId = memberService.join(user);
        //then
        User findMemeber = memberRepository.findByUserId(saveId).get();
        assertEquals(user.getUsername(),findMemeber.getUsername());
    }

    @Test
    public void duplicateError() throws Exception{
        //Given
        User user1 = new User();
        user1.setUsername("spring");

        User user2 = new User();
        user2.setUsername("spring");
        //when
        memberService.join(user1);
        IllegalStateException e = assertThrows(IllegalStateException.class ,
                () -> memberService.join(user2)); //예외가 발생 해야만 한다

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}
