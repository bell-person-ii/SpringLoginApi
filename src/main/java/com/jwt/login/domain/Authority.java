package com.jwt.login.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore//데이터 숨김처리
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "member_id")
    @JsonIgnore//데이터 숨김처리
    private Member member;

    public void setMember(Member member) {
        this.member = member;
    }
}
