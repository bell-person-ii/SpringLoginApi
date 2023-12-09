package com.jwt.login.repository;


import com.jwt.login.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member){
        em.persist(member);
    }

    public Optional<Member> findOneByAccount(String account) {
        Optional<Member> optionalMember;
        List<Member> memberList
                = em.createQuery("select m from Member m where m.account =: account")
                .setParameter("account",account)
                .getResultList();

        int size = memberList.size();
        if(size > 1 || size ==0){
            return  optionalMember = Optional.empty();
        }

        return optionalMember = Optional.of(memberList.get(0));
    }
}
