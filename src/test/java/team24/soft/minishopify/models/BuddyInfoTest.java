package team24.soft.minishopify.models;

import org.junit.Before;
import org.junit.Test;
import team24soft.minishopify.models.BuddyInfo;

import static org.junit.Assert.assertEquals;

public class BuddyInfoTest {
    BuddyInfo buddy;
    BuddyInfo buddy2;
    String firstName;
    String lastName;
    String phone;

    @Before
    public void setUp()  {
        firstName = "Jose";
        lastName = "Franco";
        phone = "123-456";

        buddy = new BuddyInfo(firstName,lastName,phone);
        buddy2 = new BuddyInfo();
    }

    @Test
    public void getFirstName(){
        assertEquals(firstName,buddy.getFirstName());
    }
    @Test
    public void getLastName(){
        assertEquals(lastName,buddy.getLastName());
    }
    @Test
    public void getPhone(){
        assertEquals(firstName,buddy.getFirstName());
    }


    @Test
    public void setFirstName(){
        buddy2.setFirstName(firstName);

        assertEquals(firstName,buddy.getFirstName());
    }
    @Test
    public void setLastName(){
        buddy2.setFirstName(lastName);

        assertEquals(lastName,buddy.getLastName());
    }
    @Test
    public void setPhone(){
        buddy2.setPhone(phone);

        assertEquals(phone,buddy.getPhone());
    }
}