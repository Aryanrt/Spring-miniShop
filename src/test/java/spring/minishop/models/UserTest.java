package spring.minishop.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    User u1;
    User u2;

    @Before
    public void setUp() {
        u1 = new User("Hassan", "Yusuf");
        u2 = new User("Jose", "Franco");
    }

    @Test
    public void getUsername(){
        assertEquals("Hassan",u1.getUsername());
    }
    @Test
    public void getPassword(){
        assertEquals("Yusuf", u1.getPassword());
    }


    @Test
    public void setUsername(){
        u2.setUsername("mamo");

        assertEquals("mamo",u2.getUsername());
    }
    @Test
    public void setPassword(){
        u2.setPassword("mamo");

        assertEquals("mamo", u2.getPassword());
    }

    @Test
    public void isOnline(){
        assertTrue(u1.isOnline());
    }

    @Test
    public void setOffline(){
        u2.setOnline(false);
        assertFalse(u2.isOnline());
    }
}