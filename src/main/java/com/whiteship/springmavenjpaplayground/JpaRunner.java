package com.whiteship.springmavenjpaplayground;

import com.whiteship.springmavenjpaplayground.entity.Member;
import com.whiteship.springmavenjpaplayground.entity.MemberWithTeam;
import com.whiteship.springmavenjpaplayground.entity.Team;
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

        Study study = new Study();
        study.setName("Spring Data JPA");

        account.addStudy(study);

        Session session = entityManager.unwrap(Session.class);
        session.save(member);
        session.save(account);
        session.save(study);
        System.out.println(" getOwner =============== ");
        System.out.println(study.getOwner());
        System.out.println(account.getStudies());
        System.out.println(" getOwner =============== ");
        /**
         * TEAM과 맴버의 단방향
         */

        Team team = new Team();
        team.setName("team1");

        MemberWithTeam memberWithTeam = new MemberWithTeam();
        memberWithTeam.setUsername("martin");
        team.getMembers().add(memberWithTeam);
        memberWithTeam.setTeam(team);

        session.save(team);
        session.save(memberWithTeam);

        System.out.println(" =============== ");
        System.out.println(team.getMembers());
        System.out.println(" =============== ");
    }
}
