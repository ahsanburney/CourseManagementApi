package com.ahsanburney.springboot.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;
	
	private List<Course> topics = new ArrayList<>(Arrays.asList(
			new Course("spring","SpringFramenwork","Spring FrameWork Description"),
			new Course("java","Core java","Core java Description"),
			new Course("javaScript","javaScript","javaScript Description")		
	        ));
	
	public List<Course> getAllCourses(String id){
		List<Course> topics = new ArrayList<>();
		courseRepository.findAll()
		.forEach(topics::add);
		return topics;
	}
	
	
	
	public Course getCourse(String id){
	return	topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	//	return topicRepository.findById(id);
		
	}

	public void addCourse(Course topic) {
	//	topicRepository.save(topic);
		topics.add(topic);
		
	}

	public void updateCourse(String id, Course topic) {
		courseRepository.save(topic);
		for(int i=0;i<topics.size();i++) {
			Course t =topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
		
	}

	public void deleteCourse(String id) {
		topics.removeIf(t-> t.getId().equals(id));
		//topicRepository.deleteById(id);
	}
	
	


}
