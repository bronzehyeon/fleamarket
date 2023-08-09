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
        validateDuplicateUserId(member);
        validateDuplicateNickname(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateUserId(Member member) {
        //Exception
        List<Member> findUserId = memberRepository.findByName(member.getUserId());
        if (!findUserId.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        }
    }
    private void validateDuplicateNickname(Member member) {
        //Exception
        List<Member> findNickname = memberRepository.findByNickname(member.getNickname());
        if (!findNickname.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 닉네임입니다.");
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
