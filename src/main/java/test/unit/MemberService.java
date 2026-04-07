package test.unit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Long join(Member member) {

        Member savedMember = memberRepository.save(member);
        return savedMember.getId();

    }

    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("해당 이메일을 가진 회원이 존재하지 않습니다."));
    }

    public void updateName(Long id ,String name) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID를 가진 회원이 존재하지 않습니다."));

        // Dirty Checking 이 일어나지만, 명시적 이해를 위해 호출 예시
        Member updateMember = new Member(member.getId(), name, member.getEmail(), member.getAge());
        memberRepository.save(updateMember);
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}
