package com.minibackend.homepage.service;

import com.alibaba.fastjson.JSON;
import com.minibackend.homepage.Application;
import com.minibackend.homepage.dao.HomepageUserCourseDao;
import com.minibackend.homepage.entity.HomepageUserCourse;
import com.minibackend.homepage.vo.CreateUserRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * <h1>用户服务测试</h1>
 * Created by Qinyi.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class HomepageUserServiceTest {

    @Autowired
    private IUserService userService;

    @Autowired
    private HomepageUserCourseDao userCourseDao;

    @Test
    @Transactional
    public void testCreateUser() {

        System.out.println(JSON.toJSONString(userService.createUser(
                new CreateUserRequest("qinyi_02", "qinyi_02@gmail.com")
        )));
    }

    @Test
    public void testGetUser() {

        System.out.println(JSON.toJSONString(userService.getUserInfo(6L)));
    }

    @Test
    public void testCreateHomepageUserCourse() {

        HomepageUserCourse course1 = new HomepageUserCourse();
        course1.setUserId(6L);
        course1.setCourseId(6L);

        HomepageUserCourse course2 = new HomepageUserCourse();
        course2.setUserId(6L);
        course2.setCourseId(7L);

        System.out.println(userCourseDao.saveAll(Arrays.asList(course1, course2)).size());
    }
}
