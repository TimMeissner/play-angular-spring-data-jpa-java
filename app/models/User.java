package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public Long id;

    public String email;

    public String username;

    public String name;

    public String bio;

    public String twitter_handle;

    public String site;
}
