# [단위 테스트(Unit Testing): 모듈 단위로 테스트를 하자.]

## 단위테스트란?
### 1. 단위 테스트의 정의와 목적
> 단위(Unit) 이란?
- 애플리케이션에서 Test 가능한 가장 단위로 주로 함수, Method, Class 등을 의미합니다.

> Test의 목적?
- 특정 Module이 의도한 대로 정확히 작동하는지 독립적으로 확인할 수 있습니다.
- 개발 단계에서 즉각적으로 버그를 발견할 수 있어 빠른 피드백이 가능합니다.
- 또한 테스트 코드 자체가 문서 역할을 하며, 다른 개발자들이 코드 사용법, 기대 결과 등에 대한 예시로 활용 가능합니다.

### 2. Testing Pyramid
- 단위 테스트(Unit) -> 통합 테스트(Integration) -> E2E 테스트(End-to-End)
- 단위 테스트는 가장 아래에 위치하며, 가장 많은 테스트 케이스를 포함해야 합니다. 단위 테스트는 빠르게 실행되고, 특정 기능을 독립적으로 검증할 수 있기 때문에 개발자들이 자주 작성하는 테스트 유형입니다.

### 3. 좋은 단위 테스트란?
> F.I.R.S.T 원칙
1. Fast: 테스트는 빨라야 하며, 수천 개를 실행해도 몇 초 이내에 끝나야 합니다.
2. Independent: 테스트는 서로 독립적이어야 하며, 순서에 상관없이 같은 결과여야 합니다.
3. Repeatable: 테스트는 언제나 같은 결과를 내야 하며, 환경(네트워크, DB 등)에 의존하지 않아야 합니다.
4. Self-Validating: 테스트는 명확한 통과/실패 기준을 가져야 하며, 사람이 결과를 해석할 필요가 없어야 합니다.(수동 확인은 금지)
5. Timely: 실제 코드를 구현하기 직전(TDD) 또는 직후에 작성해야 합니다.

### 4. 단위 테스트 작성 시 고려사항
- 테스트 대상의 범위를 명확히 정의해야 합니다. (예: 특정 함수, 클래스 등)
- Private 메서드 테스트는 권장되지 않으며, Public API를 통해 간접적으로 검증하는 것이 좋습니다.
- Mocking과 Stubbing을 활용하여 외부 의존성을 격리할 수 있습니다. (예: 데이터베이스, 네트워크 등)
- 테스트 코드 자체에 if 나 for 문 같은 복잡한 로직은 포함하지 말아야 합니다.

## JUnit 5
### Before - After
✅[Before-After 테스트 코드 보기](https://github.com/hyesuhan/UnitTest/blob/main/src/test/java/test/unit/BeforeAfterTest.java)
- @BeforeEach: 각 테스트 메서드 실행 전에 실행되는 메서드에 사용됩니다. 주로 테스트 환경을 초기화하는 데 사용됩니다.
- @AfterEach: 각 테스트 메서드 실행 후에 실행되는 메서드에 사용됩니다. 주로 테스트 환경을 정리하는 데 사용됩니다.
- @BeforeAll: 모든 테스트 메서드 실행 전에 한 번만 실행되는 메서드에 사용됩니다. 주로 테스트 클래스 전체에서 공유되는 리소스를 초기화하는 데 사용됩니다.
- @AfterAll: 모든 테스트 메서드 실행 후에 한 번만 실행되는 메서드에 사용됩니다. 주로 테스트 클래스 전체에서 공유되는 리소스를 정리하는 데 사용됩니다.

### Test 구조화 어노테이션
✅[Test 구조화 테스트 코드 보기](https://github.com/hyesuhan/UnitTest/blob/main/src/test/java/test/unit/StructureTest.java)
- @DisplayName: 테스트 클래스나 테스트 메서드에 사용자 정의 이름을 지정할 수 있습니다. 테스트 결과 보고서에서 이 이름이 표시됩니다.
- @Nested: 테스트 클래스 내에 중첩된 테스트 클래스를 정의할 수 있습니다. 이를 통해 관련된 테스트를 그룹화할 수 있습니다.
  - 또한, 부모 클래스의 멤버 변수에 접근할 수 있어 @BeforeEach같은 공통 설정을 공유하기 쉽습니다.
- @Tag: 테스트 메서드나 테스트 클래스에 태그를 지정할 수 있습니다. 이를 통해 특정 태그가 있는 테스트만 실행하거나 제외할 수 있습니다.
- @Order: 테스트 메서드의 실행 순서를 지정할 수 있습니다. 그러나 단위 테스트는 독립적이어야 하므로, 이 어노테이션은 권장되지 않습니다.

### Test Iteration
✅[Iteration 테스트 코드 보기](https://github.com/hyesuhan/UnitTest/blob/main/src/test/java/test/unit/IterationTest.java)
- @RepeatedTest: 동일한 테스트 메서드를 여러 번 반복해서 실행할 수 있습니다. 반복 횟수를 지정할 수 있으며, 각 반복에 대한 정보를 제공하는 RepetitionInfo 객체를 매개변수로 받을 수 있습니다.
- @ParameterizedTest: 다양한 입력 값으로 동일한 테스트 메서드를 실행할 수 있습니다. @ValueSource, @CsvSource, @MethodSource 등과 함께 사용하여 다양한 형태의 데이터를 제공할 수 있습니다.

### Test Assertion
- Assertions.assertEquals(expected,actual) : 예상 값과 실제 값이 같은지 검증합니다.
- Assertions.assertNotEquals(unexpected,actual) : 예상 값과 실제 값이 다른지 검증합니다.
- Assertions.assertTrue(condition) : 조건이 참인지 검증합니다.
- Assertions.assertFalse(condition) : 조건이 거짓인지 검증합니다.
- Assertions.assertNull(object) : 객체가 null인지 검증합니다.
- Assertions.assertThrows(expectedType, executable) : 특정 예외가 발생하는지 검증합니다.

## Given - When - Then
✅[Assertions 테스트 코드 보기](https://github.com/hyesuhan/UnitTest/blob/main/src/test/java/test/unit/AssertionsTest.java)
이 패턴은 단위 테스트의 표준 구조 중 하나입니다.
1. Given
- 테스트 수행 전 환경 설정과 데이터를 준비합니다.
- 이 때 테스트 객체 생성, Mock(가짜 데이터), 입력값 준비 등이 포함됩니다.
- 예: "회원 가입 테스트를 위해 이름이 "홍길동"인 회원 정보를 준비한다."

2. When
- 실제로 테스트를 하고자 하는 목적을 수행하는 단계입니다.
- 특정 메서드 호출, API 요청 등이 포함됩니다.
- 예: "회원 가입 메서드를 호출한다."

3. Then
- 테스트 결과를 검증하는 단계입니다.
- Assertions를 사용하여 예상 결과와 실제 결과를 비교합니다.
- 예: "회원 가입이 성공적으로 이루어지고, 회원 이름이 홍길동인지 확인한다."

쓰는 이유는 간단합니다.
- 처음 보는 사람들도 어떤 상황에서 이 행동을 하면, 이렇게 되는 구나를 이해 가능합니다.
- 테스트 실패 시 어느 단계에서 문제가 생겼는지 확인 가능합니다.
- 테스트 코드 자체만으로 Spec을 이해할 수 있어 문서화 역할을 합니다.

✨TIP
주석을 명확히 달거나 줄바꿈을 적절히 활용합시다!


# [Mocking: 외부 의존성을 격리하자.]
## Mockito란?
- 자바에서 가짜 객체(Mock Object)를 생성하고, 그 객체의 동작을 정의(Stubbing)하며, 실제 호출되었는지 검증(Verification) 할 수 있게 하는 프레임워크입니다.
- 만약 MemberService를 테스트하려는데, DB나 외부 결제 API를 Autowired 하고 있다면, 이는 단위 테스트가 아닌 통합 테스트가 됩니다.
- 그렇기에 Mockito는 이 의존성을 가짜(Mock)로 대체해줍니다.

## 관련 어노테이션
✅[Mockito 테스트 코드 보기](https://github.com/hyesuhan/UnitTest/blob/main/src/test/java/test/unit/MemberServiceTest.java)
- @Mock: 테스트 클래스에서 Mock 객체를 생성하는 데 사용됩니다. 이 어노테이션이 붙은 필드는 Mockito에 의해 자동으로 Mock 객체로 초기화됩니다.
- @InjectMocks: 테스트 클래스에서 실제 객체를 생성하고, @Mock으로 생성된 Mock 객체를 주입하는 데 사용됩니다. 이 어노테이션이 붙은 필드는 Mockito에 의해 자동으로 초기화되고, 필요한 Mock 객체가 주입됩니다.
- @Spy: 실제 객체를 감싸는 Spy 객체를 생성하는 데 사용됩니다. Spy 객체는 실제 메서드를 호출하지만, 필요에 따라 특정 메서드의 동작을 정의할 수 있습니다.

## Stubbing & Verification
1. Stubbing
- 메서드가 호출되면 이 값을 돌려 달라고 미리 정해두는 과정입니다.
```java
// memberRepository의 findById 메서드가 1L을 인자로 받으면, Optional.of(member)를 반환하도록 설정한다.
when(memberRepository.findById(1L)).thenReturn(Optional.of(member));
```

2. Verification
- 실제로 이 메서드가 몇 번 호출되었는지를 확인합니다.
- 결과 뿐 아니라 객체 간 상호작용을 확인합니다.
```java
// memberRepository의 save 메서드가 정확하게 1번만 호출되었는지 확인
verify(memberRepository, times(1)).save(any(Member.class));mberRepos)
```


# [Integration Test: 모듈 간 상호작용을 검증하자.]
## 통합 테스트란?
✅[통합 테스트 관련 코드 보기](https://github.com/hyesuhan/UnitTest/blob/main/src/test/java/test/unit/MemberServiceIntegrationTest.java)
- 단위 테스트가 개별 모듈의 기능을 검증하는 데 초점을 맞춘다면, 통합 테스트는 여러 모듈이 함께 작동할 때의 상호작용과 통합된 기능을 검증하는 테스트입니다.
- 단위 테스트 시 Spring은 동작하지 않지만, @SpringBootTest 어노테이션을 통해 spring이 동작되게 할 수 있습니다.
- 테스트 수행 시 다음의 스프링이 동작합니다.
  - Spring IoC/DI 기능을 사용 가능합니다.
  - Repository를 사용해서 DB CRUD 가 가능합니다.


## @Transactional이 필요한 이유
- 통합 테스트 시 DB를 사용하게 되는데, 이 때 테스트 데이터가 DB에 남아있을 수 있습니다.
- 테스트 클래스에 @Transactional 어노테이션을 붙이면, 각 테스트 메서드가 실행된 후에 트랜잭션이 롤백되어 DB 상태가 초기화됩니다.
- 즉, 테스트가 끝나자마자 DB를 RollBac 하게 됩니다.

## Testcontainers
- 우리는 현재 DB를 실제로 띄우는 것에 집중하는 것이 아닌, 오직 테스트를 위한 DB를 올릴 것 입니다.
- 따라서 이에 아주 잘 맞는 환경인 Docker을 활용해 일시적으로 올리고 DB를 내려 버리면 됩니다.
- 그러나 당연히 단점으로는 Container을 올리는 데 시간이 걸립니다.

