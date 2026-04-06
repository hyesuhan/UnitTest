package test.unit;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository {

    Member save(Member member);

    Optional<Member> findById(Long id);
}
