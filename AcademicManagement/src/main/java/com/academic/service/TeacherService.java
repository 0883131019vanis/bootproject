package com.academic.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.academic.entity.Teacher;
import com.academic.repository.TeacherRepository;
@Service
public class TeacherService {
	@Autowired
	TeacherRepository teacherRepository;

	public void addTeacher(Teacher teacher) {
		teacherRepository.save(teacher);

	}
	public List<Teacher> getAllTeacher() {
		return teacherRepository.findAll();
	}
	public Teacher getTeacherId(long id) {
		Optional<Teacher> teacher=teacherRepository.findById(id);
		if(teacher.isPresent())
		{
			return teacher.get();
		}
		return null;
	}
	public void deleteTeacherById(Long id) {
		teacherRepository.deleteById(id);		
	}
	public List<Teacher> findTeacherDetails() {
		List<Teacher> teacher=teacherRepository.findAll();


		for (Teacher name : teacher) {
			System.out.println(name);
		}
		return teacher;
	}

}
