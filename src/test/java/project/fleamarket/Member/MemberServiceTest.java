package project.fleamarket.Member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Rollback(value = false)
    public void 회원가입() throws Exception{
        //given
        Member member1 = new Member("id1","name1","pw1","nickname1");
        Member member2 = new Member("id2","name2","pw2","nickname2");
        Member member3 = new Member("id3","name3","pw3","nickname3");
        Member member4 = new Member("id4","name4","pw4","nickname4");
        Member member5 = new Member("id5","name5","pw5","nickname5");

        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);
        memberRepository.save(member4);
        memberRepository.save(member5);

        //when



        //then


    }

    @Test
    public void 중복_회원_예외() throws Exception {
        //given

        //when

        //then

    }
}