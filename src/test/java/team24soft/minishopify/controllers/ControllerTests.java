package team24soft.minishopify.controllers;
import static org.junit.matchers.JUnitMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import team24soft.minishopify.models.Cart;
import team24soft.minishopify.models.Product;
import team24soft.minishopify.models.Shop;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTests {
    @Autowired
    MockMvc mockMvc;
    @InjectMocks
    shopMVCController controller;

    @Before
    void setup()  throws Exception {
        controller = new shopMVCController();
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test/* /CreateShop Test */
    void a() throws Exception {

        this.mockMvc.perform(post("/createShop").param("name","coca"))
                .andExpect(content().string(containsString("coca")));
    }
    @Test/* /getManagerShop Test */
    void b() throws Exception {

        this.mockMvc.perform(get("/getManagerShop").param("id","1"))
                .andExpect(content().string(containsString("coca")));
    }

    @Test/* /addItem Test */
    void c() throws Exception {

        this.mockMvc.perform(get("/addItem").param("id","1")
                .param("name","sprite").param("description","sweet")
                .param("price","2").param("quantity","100"))
                .andExpect(content().string(containsString("sprite")))
                .andExpect(content().string(containsString("sweet")))
                .andExpect(content().string(containsString("2")))
                .andExpect(content().string(containsString("100")));
    }

    @Test/* /getBuyerShop Test */
    void d() throws Exception {

        this.mockMvc.perform(get("/getBuyerShop").param("name","coca"))
                .andExpect(content().string(containsString("coca")))
                .andExpect(content().string(containsString("sprite")))
                .andExpect(content().string(containsString("sweet")))
                .andExpect(content().string(containsString("2")));
    }
    @Test/* /addtoCart and viewCart Test */
    void e() throws Exception {

        this.mockMvc.perform(get("/addToCart").param("name","coca")
                .param("title","sprite").param("number","4"));
        this.mockMvc.perform(get("/viewCart"))
                .andExpect(content().string(containsString("sprite")))
                .andExpect(content().string(containsString("sweet")))
                .andExpect(content().string(containsString("4")));;


    }
}
