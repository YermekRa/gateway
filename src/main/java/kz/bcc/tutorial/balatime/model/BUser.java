package kz.bcc.tutorial.balatime.model;

import lombok.Data;

import javax.persistence.*;

@Table(name = "b_user")
@Data
@Entity
public class BUser {

    @Id
    @SequenceGenerator(name = "user_id_seq",
            sequenceName = "user_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "user_id_seq")
    private Long id;

    @Column(name = "arcfl")
    private Integer arcfl;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "role_id")
    private Integer roleId;

}
