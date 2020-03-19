package team24soft.minishopify.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Buyer{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public long id;

}
