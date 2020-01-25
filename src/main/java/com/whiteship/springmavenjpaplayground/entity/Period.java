package com.whiteship.springmavenjpaplayground.entity;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Embeddable
public class Period {
    // 근무 기간 표시
    @Temporal(TemporalType.TIME)
    private Date startedAt;

    @Temporal(TemporalType.TIME)
    private Date finishedAt;
}
