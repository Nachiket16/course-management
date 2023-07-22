package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Courses;
@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;
	
//	List<Courses> list;

	public CourseServiceImpl() {
//		list = new ArrayList<Courses>();
//		list.add(new Courses(145, "Java Course", "This is OOP with Java"));
//		list.add(new Courses(4545, "Spring Boot Course", "This is Web dev using spring Framework"));
	}

	@Override
	public List<Courses> getCourses() {
		// TODO Auto-generated method stub
		return courseDao.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Courses getCourse(long courseId) {
		// TODO Auto-generated method stub
//		Courses c = null;
//		for(Courses course: list) {
//			if(course.getId() == courseId) {
//				c= course;
//				break;
//			}
//		}
		return courseDao.getOne(courseId);
	}

	@Override
	public Courses addCourse(Courses course) {
//		// TODO Auto-generated method stub
//		list.add(course);
		courseDao.save(course);
		return course;
	}

	@Override
	public Courses updateCourse(Courses course) {
		// TODO Auto-generated method stub
//		list.forEach(e ->{
//			if(e.getId()== course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
		// TODO Auto-generated method stub
//		list =  this.list.stream()
//			    .filter(l -> l.getId()!= parseLong)
//			    .collect(Collectors.toList());
		Courses entity = courseDao.getOne(parseLong);
		courseDao.delete(entity);
	}

}
