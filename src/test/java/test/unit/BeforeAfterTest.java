package test.unit;

import org.junit.jupiter.api.*;

public class BeforeAfterTest {

    @BeforeEach
    void setUp() {
        System.out.println("각 테스트 코드가 실행되기 전에 수행됩니다.");
    }

    @AfterEach
    void tearDown() {
        System.out.println("각 테스트 코드가 실행된 후에 수행됩니다.\n");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("테스트 클래스 내의 모든 테스트 코드가 실행되기 전에 수행됩니다.\n");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("테스트 클래스 내의 모든 테스트 코드가 실행된 후에 수행됩니다.");
    }

    @Test
    void test_1() {
        System.out.println("테스트 코드 1이 실행됩니다.");
    }

    @Test
    void test_2() {
        System.out.println("테스트 코드 2가 실행됩니다.");
    }
}
