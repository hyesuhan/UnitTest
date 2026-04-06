package test.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @Test
    @DisplayName(" 회원 가입이 성공하면 저장된 ID를 반환해야 한다.")
    void join() {
        // Given
        Member member = new Member(1L, "홍길동", "hong@test.com", 25);

        // stubbing: memberRepository.save() 메서드가 호출되면 member 객체를 반환하도록 설정
        given(memberRepository.save(any(Member.class))).willReturn(member);

        // When
        Long savedId = memberService.join(member);

        // Then
        Assertions.assertEquals(member.getId(), savedId, "회원 가입이 성공하면 저장된 ID를 반환해야 합니다.");

        verify(memberRepository, times(1)).save(any(Member.class));

    }
}
