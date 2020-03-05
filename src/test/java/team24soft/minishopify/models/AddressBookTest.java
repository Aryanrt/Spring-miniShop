package team24soft.minishopify.models;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class AddressBookTest {

    AddressBook addressBook;
    BuddyInfo buddyInfo;
    BuddyInfo buddyInfo0;
    @Before
    public void setUp() {
        addressBook = new AddressBook();
        buddyInfo0 = new BuddyInfo("Fabiola","Orozco","12312");
        buddyInfo = new BuddyInfo("Jose","Franco", "123");
        addressBook.addBuddy(buddyInfo0);
    }

    @Test
    public void AddBuddy(){
        int prevoiusSize = addressBook.getAgenda().size();

        addressBook.addBuddy(buddyInfo);

        int currentSize = addressBook.getAgenda().size();
        assertEquals(prevoiusSize, currentSize -1);
    }

    @Test
    public void RemoveBuddy(){
        int prevoiusSize = addressBook.getAgenda().size();

        addressBook.removeBuddy(buddyInfo0);

        int currentSize = addressBook.getAgenda().size();

        assertEquals(prevoiusSize, currentSize + 1);
    }

    @Test
    public void ToString(){
        String result = "Address Book \n" +"BuddyInfo [" +
                "firstName='" + buddyInfo0.getFirstName() + '\'' +
                ", lastName='" + buddyInfo0.getLastName() + '\'' +
                ", phone='" + buddyInfo0.getPhone() + '\'' +
                ", id=" + buddyInfo0.getId() +
                ']' + "\n";

        assertEquals(result,addressBook.toString());
    }


}
