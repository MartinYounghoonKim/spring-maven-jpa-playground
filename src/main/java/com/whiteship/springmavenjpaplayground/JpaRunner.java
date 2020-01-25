package com.whiteship.springmavenjpaplayground;

import com.whiteship.springmavenjpaplayground.entity.Member;
import com.whiteship.springmavenjpaplayground.entity.Period;
import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setUsername("Martin");
        account.setPassword("martin");

        Member member = new Member();
        member.setName("Martin");
        member.setPeriod(null);
        member.setAddress1(null);

        Session session = entityManager.unwrap(Session.class);
        session.save(member);
        session.save(account);
    }
}
