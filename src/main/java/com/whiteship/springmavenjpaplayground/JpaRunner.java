package com.whiteship.springmavenjpaplayground;

import com.whiteship.springmavenjpaplayground.entity.Member;
import com.whiteship.springmavenjpaplayground.entity.MemberWithTeam;
import com.whiteship.springmavenjpaplayground.entity.Team;
import javafx.geometry.Pos;
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
        Session session = entityManager.unwrap(Session.class);

        Post post = new Post();
        post.setTitle("제목1");
        Comment comment = new Comment();
        comment.setComment("코멘트1");
        post.addComment(comment);

        Comment comment1 = new Comment();
        comment1.setComment("곧 보여드릴게요.");
        post.addComment(comment1);

        session.save(post);
        /**
         * Account 클래스와 Study 클래스 양방향 관계
         */
//        Account account = new Account();
//        account.setUsername("Martin");
//        account.setPassword("martin");
//
//        Study study = new Study();
//        study.setName("Spring Data JPA");
//
//        account.addStudy(study);
//
//        session.save(account);
//        session.save(study);

        /**
         * Member 클래스
         */
//        Member member = new Member();
//        member.setName("Martin");
//        member.setPeriod(null);
//        member.setAddress1(null);
//        session.save(member);

        /**
         * TEAM과 맴버의 단방향
         */
//        Team team = new Team();
//        team.setName("team1");
//
//        MemberWithTeam memberWithTeam = new MemberWithTeam();
//        memberWithTeam.setUsername("martin");
//        team.getMembers().add(memberWithTeam);
//        memberWithTeam.setTeam(team);
//
//        session.save(team);
//        session.save(memberWithTeam);
//
//        System.out.println(" =============== ");
//        System.out.println(team.getMembers());
//        System.out.println(" =============== ");
    }
}
