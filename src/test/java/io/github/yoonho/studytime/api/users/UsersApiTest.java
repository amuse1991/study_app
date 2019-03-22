package io.github.yoonho.studytime.api.users;

import io.github.yoonho.studytime.api.AbstractApiTest;
import io.github.yoonho.studytime.domain.users.Users;
import io.github.yoonho.studytime.dto.users.UserInfoResDto;

import org.junit.Before;
import org.junit.Test;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import com.fasterxml.jackson.databind.ObjectMapper;


public class UsersApiTest extends AbstractApiTest {

    private String rootUri = "/users";
    private ObjectMapper objectMapper;

    @Override
    @Before
    public void setUp(){
        super.setUp();
        this.objectMapper = new ObjectMapper();
    }

    @Test
    public void getUser() throws Exception{
        //given
        String userId = "estrella917@naver.com";
        String uri = rootUri+"/"+userId;

        //when
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                        .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        //then
        //check status
        int status = mvcResult.getResponse().getStatus();
        assertThat(200,is(status));

        //check value
        String content = mvcResult.getResponse().getContentAsString();
        UserInfoResDto userInfo = objectMapper.readValue(content,UserInfoResDto.class);
        assertThat(userInfo.getUserId(),is(userId));
    }
}
