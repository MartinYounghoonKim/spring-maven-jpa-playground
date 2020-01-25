package com.whiteship.springmavenjpaplayground;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Account {
    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    // @Column 이 생략되어있다고 생각해도 된다.
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();

    @Transient // 컬럼으로 맵핑되지 않는다.
    private Boolean no;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "home_street"))
    })
    private Address address;

    @OneToMany(mappedBy = "owner")
    private Set<Study> studies = new HashSet();

    public Set<Study> getStudies() {
        return studies;
    }

    public void setStudies(Set<Study> studies) {
        this.studies = studies;
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

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", created=" + created +
                ", no=" + no +
                ", address=" + address +
                ", studies=" + studies +
                '}';
    }

    public void addStudy (Study study) {
        // 양방향 관계일 때, 두 Entity 에 데이터를 셋팅해야 한다.
        this.getStudies().add(study);
        study.setOwner(this);
    }

    public void removeStudy (Study study) {
        this.getStudies().remove(study);
        study.setOwner(null);
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

