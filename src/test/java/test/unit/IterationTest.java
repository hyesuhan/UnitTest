package test.unit;

import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Value;

public class IterationTest {

    @RepeatedTest(value = 3, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("반복 테스트")
    void repeatTest() {
        System.out.println("반복 테스트가 실행됩니다.");
    }

    @DisplayName("반복 테스트 2 : w. string parameter")
    @ParameterizedTest(name = "{displayName} - {index} : {arguments}")
    @ValueSource(strings = {"첫 번째", "두 번째", "세 번째"})
    void parameterizedTest(String value) {
        System.out.println("반복 테스트 2가 실행됩니다. 입력값 : " + value);
    }

    @DisplayName("반복 테스트 3 : w. int parameter")
    @ParameterizedTest(name = "{displayName} - {index} : {arguments}")
    @ValueSource(ints = {1, 2, 3})
    void parameterizedTest2(int value) {
        System.out.println("반복 테스트 3이 실행됩니다. 입력값 : " + value);
    }

}
