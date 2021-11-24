package com.xqr.springboot.service;

import com.xqr.springboot.Start;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes ={Start.class})
@AutoConfigureMockMvc
public class TestController {

    @Resource
    private MockMvc mockMvc;

    @Test
    public void test() throws Exception {
        //构建请求
        MockHttpServletRequestBuilder builder= MockMvcRequestBuilders.get("/user/id/1")
                .contentType ("text/html")
                .accept (MediaType. APPLICATION_JSON);
        //发送请求
        ResultActions perform =mockMvc.perform(builder);
        //请求校验
        perform.andExpect(MockMvcResultMatchers.status().isOk());
        //获取返回结果
        MvcResult result = perform.andReturn();
        //得到响应对象
        MockHttpServletResponse response = result.getResponse();
        //得到状态码
        System.out.println("状态码"+response.getStatus());
        System.out.println("相应数据"+response.getContentAsString());

    }
}
