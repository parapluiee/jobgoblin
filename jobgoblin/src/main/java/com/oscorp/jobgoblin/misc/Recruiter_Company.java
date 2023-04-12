package com.oscorp.jobgoblin.misc;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "recruiter_company")
@NoArgsConstructor
@Getter
@Setter
public class Recruiter_Company {
    @Id
    private Long comid;
    @Id
    private Long recid;
    int rel;
    public Recruiter_Company(long comid, long recid, int rel){
        this.comid = comid;
        this.recid = recid;
        this.rel = rel;
    }

    public long getRecid(){
        return recid;
    }

    public long getComid(){
        return comid;
    }

    public int getRel(){return rel;}
}
