package com.oscorp.jobgoblin.misc;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

    @Entity
    @Table(name = "recruiter_job")
    @NoArgsConstructor
    @Getter
    @Setter
    public class Recruiter_Job {
        @Id
        private Long jobid;
        @Id
        private Long recid;
        int rel;
        public Recruiter_Job(long jobid, long recid, int rel){
            this.jobid = jobid;
            this.recid = recid;
            this.rel = rel;
        }}
