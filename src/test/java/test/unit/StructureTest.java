package test.unit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class StructureTest {

    @Nested
    @DisplayName("주제 별로 테스트를 그룹화할 수 있습니다.")
    class Test_1 {

        @Test
        @DisplayName("Test 1")
        void test_1() {
            System.out.println("Test 1이 실행됩니다.");
        }

        @Test
        @DisplayName("Test 2")
        void test_2() {
            System.out.println("Test 2가 실행됩니다.");
        }
    }

    @Nested
    @DisplayName("주제 별로 테스트를 그룹화할 수 있습니다.")
    class Test_2 {

        @Test
        @DisplayName("Test 1")
        void test_1() {
            System.out.println("Test 1이 실행됩니다.");
        }

        @Test
        @DisplayName("Test 2")
        void test_2() {
            System.out.println("Test 2가 실행됩니다.");
        }
    }
}
