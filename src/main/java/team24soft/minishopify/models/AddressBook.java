package team24soft.minishopify.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<BuddyInfo> agenda;

    public AddressBook(){
        this.agenda = new ArrayList<BuddyInfo>();
    }
    public AddressBook(long id){
        this.id = id;
        this.agenda = new ArrayList<BuddyInfo>();
    }

    public void addBuddy(BuddyInfo buddy){
        this.agenda.add(buddy);
    }

    public void removeBuddy(BuddyInfo buddy){
        this.agenda.remove(buddy);
    }

    public List<BuddyInfo> getAgenda(){
        return agenda;
    }

    public void setAgenda(List<BuddyInfo> agenda) {
        this.agenda = agenda;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String result = "Address Book \n";

        for(BuddyInfo buddy : agenda){
            result += buddy.toString() +"\n";
        }

        return  result;
    }
}
