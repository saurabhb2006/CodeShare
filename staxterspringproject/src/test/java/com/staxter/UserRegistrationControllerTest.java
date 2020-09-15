package com.staxter;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;

import com.staxter.userrepository.UserRepositoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@WebMvcTest(UserRegistrationController.class)
public class UserRegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepositoryService userRepositoryService;

    @Test
    public void createItem() throws Exception {
        String exampleJson = "{\"firstName\":\"Saurabh\",\"lastName\":\"Bhasin\",\"userName\":\"saurabhb\",\"password\":\"123456\"}";

        RequestBuilder request = MockMvcRequestBuilders
                .post("/userservice/register")
                .accept(MediaType.APPLICATION_JSON)
                .content(exampleJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());

    }
}
