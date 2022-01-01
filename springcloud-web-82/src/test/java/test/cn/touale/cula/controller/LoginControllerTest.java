package test.cn.touale.cula.controller;


import cn.touale.cula.WebApplication_81;
import cn.touale.cula.controller.LoginController;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * LoginController Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>1月 1, 2022</pre>
 */

@RunWith(SpringRunner.class)
//@WebMvcTest(value = LoginController.class)
@SpringBootTest(classes = WebApplication_81.class)
public class LoginControllerTest {

    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void before() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: doLogin(@RequestBody JSONObject jsonParam, HttpServletRequest request)
     */
    @Test
    public void testDoLogin_failLogin() throws Exception {
        JSONObject jsonParam = new JSONObject();
        jsonParam.put("uname", "touale");
        jsonParam.put("upwd", "1");
        String requestJson = jsonParam.toJSONString();
        System.out.println(requestJson);
        mockMvc.perform(post("/doLogin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("0"))
                .andReturn()
                .getResponse()
                .getContentAsString();

    }

    @Test
    public void testDoLogin_succLogin() throws Exception {
        JSONObject jsonParam = new JSONObject();
        jsonParam.put("uname", "touale");
        jsonParam.put("upwd", "123");
        String requestJson = jsonParam.toJSONString();
        System.out.println(requestJson);
        mockMvc.perform(post("/doLogin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("1"))
                .andReturn()
                .getResponse()
                .getContentAsString();

    }


}


