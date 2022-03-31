package com.academic.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.academic.entity.Student;
import com.academic.repository.StudentRepository;
@Service
 public class StudentService   {
		@Autowired
		private StudentRepository studentRepository;

		public void addStudent(Student student) {

			studentRepository.save(student);
		}

		public List<Student> getAllStudent() {

			return studentRepository .findAll();
		}

		public Student getStudentId(long id) {
			Optional<Student> student=studentRepository.findById(id);
			if(student.isPresent())
			{
				return student.get();
			}
			return null;
		}

		public void deleteStudentById(Long id) {
			studentRepository.deleteById(id);		
		}

		public List<Student> findStudentDetails() {
			List<Student> student=studentRepository.findAll();


			for (Student name : student) {
				System.out.println(name);
			}
			return student;


		}}
