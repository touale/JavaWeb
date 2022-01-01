package test.cn.touale.cula.controller;

import cn.touale.cula.WebApplication_81;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * UtilController Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>1月 1, 2022</pre>
 */
@RunWith(SpringRunner.class)
//@WebMvcTest(value = LoginController.class)
@SpringBootTest(classes = WebApplication_81.class)
public class UtilControllerTest {

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
     * Method: doAddComment(@RequestParam(name = "nid") Long nid, @RequestBody JSONObject jsonParam)
     */
    @Test
    public void testDoAddComment() throws Exception {

    }

    /**
     * Method: doUpdateNews(@RequestBody JSONObject jsonParam)
     */
    @Test
    public void testDoUpdateNews() throws Exception {

    }

    /**
     * Method: doAddNews(@RequestBody JSONObject jsonParam)
     */
    @Test
    public void testDoAddNews() throws Exception {
        JSONObject jsonParam = new JSONObject();

        jsonParam.put("nauthor", "测试作者");
        jsonParam.put("ncontent", "测试内容");
        jsonParam.put("nsummary", "测试摘要");
        jsonParam.put("ntid", "科技");
        jsonParam.put("ntitle", "测试标题");

        String requestJson = jsonParam.toJSONString();
        System.out.println(requestJson);
        mockMvc.perform(post("/do_add_news")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("1"))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    /**
     * Method: doAddTopic(@RequestBody JSONObject jsonParam)
     */
    @Test
    public void testDoAddTopic() throws Exception {

    }

    /**
     * Method: updateTopic(@RequestBody JSONObject jsonParam)
     */
    @Test
    public void testUpdateTopic() throws Exception {

    }


} 
