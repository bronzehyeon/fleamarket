package project.fleamarket.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;


    @Autowired
    public MemberService(MemberRepository memberRepository) {//@AllArgsConstructor 로 대체 가능// RequiredArgsConstructor(final 붙은것만 가지고 생성자 생성
        this.memberRepository = memberRepository;
    }

    //회원가입
    @Transactional

    public Long join(Member member) {
//        validateDuplicateUser(user);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateUser(Member member) {
        //Exception
        List<Member> findName = memberRepository.findByName(member.getName());
        if (!findName.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원전체 조회
    public List<Member> findUsers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long userId) {
        return memberRepository.findOne(userId);
    }
}
