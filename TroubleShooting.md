## Lombok 및 기본 컴파일 에러
> 문제: cannot find symbol(getName(), getId())
- 원인: Lombok이 제대로 작동하지 않아서 getter 메서드가 생성되지 않음
- 해결: build.gradle에 annotationProcessor 설정 추가 & IDE 설정에서 Enable anotation processing 체크

## 스프링 컨테이너와 Bean 주입
> 문제: UnsatisfiedDependencyException
- 원인: @SpringBootTest 는 실제 빈을 찾는데, Interface만 존재하고 구현체나 가짜 객체가 컨테이너에 없는 상황
- 해결: 단위 테스트라면, @MockitoBean 을 통해 가짜 객체를 주입하고, 통합 테스트라면 실제 Repository 구현체가 빈으로 등록되어 있는지 확인

## TestContainers 및 Docker 환경
> 문제: DB설정 없이 오직 @TestContainers 만으로는 DB가 자동으로 생성되지 않음
- 원인: TestContainers는 Docker 컨테이너를 통해 DB를 띄우지만, 스프링이 이 DB에 연결하려면 DataSource 설정이 필요
- 해결: application-test.properties 에서 spring.datasource.url, username, password 등을 TestContainers에서 띄운 DB에 맞게 설정하거나, @DynamicPropertySource 어노테이션을 사용하여 런타임에 프로퍼티를 동적으로 설정
- 나는 properties 에서 ddl-auto=update 로 설정했는데, 이 설정은 스프링이 애플리케이션 실행 시점에 DB 스키마를 자동으로 업데이트하도록 하는 설정함.

## JPA 엔티티 매핑 및 Table 설정
> 문제: Not a managed type: class test.unit.Member
- 원인: JPA 관리 클래스에 @Entity어노테이션 누락
- 해결: @Entity 어노테이션 추가 및 @Id 설정, 위의 동일 해결로 테이블 생성
