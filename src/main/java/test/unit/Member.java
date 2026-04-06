package test.unit;

import lombok.Getter;

@Getter
public class Member {
    private Long id;

    private String name;

    private String email;

    private int age;

    // 기본 생성자
    public Member(Long id, String name, String email, int age) {
        if(!isEmailValid(email)) {
            throw new IllegalArgumentException("유효하지 않은 이메일 형식입니다.");
        }

        if(!isAgeValid(age)) {
            throw new IllegalArgumentException("유효하지 않은 나이입니다. 나이는 0 이상 120 이하이어야 합니다.");
        }

        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public boolean isAdult() {
        return age >= 18;
    }

    /** private method **/
    private boolean isEmailValid(String email) {
        // 이메일 유효성 검사 로직 (예: 간단한 정규식 검사)
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    private boolean isAgeValid(int age) {
        // 나이 유효성 검사 로직 (예: 0 이상 120 이하)
        return age >= 0 && age <= 120;
    }

}
