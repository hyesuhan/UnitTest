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
}
