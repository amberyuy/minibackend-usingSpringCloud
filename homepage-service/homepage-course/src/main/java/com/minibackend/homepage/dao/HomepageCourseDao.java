package com.minibackend.homepage.dao;

import com.minibackend.homepage.entity.HomepageCourse;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <h1>homepage_course 表访问接口定义</h1>
 */
public interface HomepageCourseDao extends JpaRepository<HomepageCourse, Long> {
}
