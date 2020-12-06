package com.minibackend.homepage.service.impl;

import com.imooc.homepage.CourseInfo;
import com.imooc.homepage.CourseInfosRequest;
import com.minibackend.homepage.dao.HomepageCourseDao;
import com.minibackend.homepage.entity.HomepageCourse;
import com.minibackend.homepage.service.ICourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <h1>课程服务功能实现</h1>
 */
@Slf4j
@Service
public class CourseServiceImpl implements ICourseService {

    /** HomepageCourse Dao */
    private final HomepageCourseDao homepageCourseDao;

    @Autowired
    public CourseServiceImpl(HomepageCourseDao homepageCourseDao) {
        this.homepageCourseDao = homepageCourseDao;
    }

    @Override
    public CourseInfo getCourseInfo(Long id) {

        Optional<HomepageCourse> course = homepageCourseDao.findById(id);
        return buildCourseInfo(course.orElse(HomepageCourse.invalid()));
    }

    @Override
    public List<CourseInfo> getCourseInfos(CourseInfosRequest request) {

        if (CollectionUtils.isEmpty(request.getIds())) {
            return Collections.emptyList();
        }

        List<HomepageCourse> courses = homepageCourseDao.findAllById(request.getIds());
        return courses.stream().map(this::buildCourseInfo).collect(Collectors.toList());

//        throw new RuntimeException("Error");
    }

    private CourseInfo buildCourseInfo(HomepageCourse course) {

        return CourseInfo.builder()
                .id(course.getId())
                .courseName(course.getCourseName())
                .courseType(course.getCourseType() == 0 ? "免费课程" : "实战课程")
                .courseIcon(course.getCourseIcon())
                .courseIntro(course.getCourseIntro())
                .build();
    }
}
