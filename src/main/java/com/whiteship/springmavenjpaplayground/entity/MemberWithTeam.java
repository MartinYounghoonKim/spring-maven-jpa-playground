package com.whiteship.springmavenjpaplayground.entity;

import javax.persistence.*;

@Entity
public class MemberWithTeam {
    @Id @GeneratedValue @Column(name = "member_id")
    private Long id;

    private String username;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public void setTeam (Team team) {
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }
}
