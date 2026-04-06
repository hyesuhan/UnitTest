package test.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Member Domain Test W. Assertions")
class AssertionsTest {

    @Test
    @DisplayName("Member 객체의 값 일치 확인: assertEquals")
    void 멤버생성자테스트() {
        // given
        String expectedName = "홍길동";

        // when
        Member member = new Member(1L, expectedName, "test@test.com", 25);
        String savedName = member.getName();

        // Then
        Assertions.assertEquals(expectedName, savedName, "Member 객체의 이름이 일치해야 합니다.");

    }

    @Test
    @DisplayName("20세 이상은 성인이여야 합니다.")
    void 성인여부확인테스트() {
        // given
        int adultAge = 20;
        Member member = new Member(1L, "성인", "adult@test.com", adultAge);

        // when
        boolean result = member.isAdult();

        // Then
        Assertions.assertTrue(result, "20세 이상은 성인이여야 합니다.");

    }

    @Test
    @DisplayName("회원 가입 시 아이디가 반드시 생겨야 합니다.")
    void 아이디는_Null이_불가합니다() {
        // given
        Member member;

        // when
        member = new Member(100L, "홍길동", "hong@test.com", 30);

        // Then
        Assertions.assertNotNull(member.getId(), "회원 가입 시 아이디가 반드시 생겨야 합니다.");
    }

    @Test
    @DisplayName("회원 가입 시 지정된 이메일 형식이 아니면 예외가 발생해야 합니다.")
    void 이메일확인테스트() {
        // given
        String invalidEmail = "invalid-email";

        // when & Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Member(1L, "홍길동", invalidEmail, 25);
        }, "회원 가입 시 지정된 이메일 형식이 아니면 예외가 발생해야 합니다.");
    }

}
