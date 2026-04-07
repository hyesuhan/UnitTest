package test.unit;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
                properties = {"spring.jpa.hibernate.ddl-auto=create"}) // 서버의 PORT를 랜덤으로 설정
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // 테스트 인스턴스의 생성 단위를 클래스로 변경합니다.
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // 테스트는 순차적으로 진행이 안 될 수 있습니다. 그렇기에 순서를 지정합니다.
@Testcontainers
public class MemberServiceIntegrationTest {

    @Container
    @ServiceConnection
    static MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8.0-debian");

    @Autowired
    MemberService memberService;

    // DB를 도커 컨테이너로 일시적으로 사용함.
    @Autowired
    MemberRepository memberRepository;

    // 공유로 사용하는 자원
    Member member;

    @Test
    @Order(1)
    @DisplayName("신규 회원 등록")
    void 신규_회원_등록() {

        // Given
        Long id = 1L;
        String name = "홍길동";
        String email = "hong@test.com";
        int age = 25;
        member = new Member(id, name, email, age);

        // When
        Long savedId = memberService.join(member);

        // Then
        Member findMember = memberRepository.findById(savedId).get();
        Assertions.assertEquals(member.getName(), findMember.getName());
        Assertions.assertEquals(member.getEmail(), findMember.getEmail());

    }

    @Test
    @Order(2)
    @DisplayName("회원의 이름을 수정하면 DB에 반영 되어야 한다.")
    void 회원_이름_수정() {
        // Given
        String newName = "홍길순";

        // When
        memberService.updateName(member.getId(), newName);

        // Then
        Member findMember = memberRepository.findById(member.getId()).get();
        Assertions.assertEquals(newName, findMember.getName());
    }

    @Test
    @Order(3)
    @DisplayName("회원을 삭제하면 더 이상 조회되지 않아야 한다.")
    void 회원_삭제() {
        // When
        memberService.deleteMember(member.getId());

        // Then
        Assertions.assertFalse(memberRepository.findById(member.getId()).isPresent(), "회원을 삭제하면 더 이상 조회되지 않아야 합니다.");

    }
}
