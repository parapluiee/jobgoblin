package com.oscorp.jobgoblin.comlogin;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "comlogin")
@NoArgsConstructor
@Getter
@Setter
public class ComLogin {
    @Id
    private Long comid;
    private String user;
    private String pass;

    public ComLogin(long comid, String user, String pass){
        this.comid = comid;
        this.user = user;
        this.pass = pass;
    }
}
