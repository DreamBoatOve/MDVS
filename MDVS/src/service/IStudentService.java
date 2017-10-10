package service;

import java.util.List;

import beans.Student;

public interface IStudentService 
{
	void addStudent(Student stu);
	void removeStudent(int id);
	void modifyStudent(Student stu);
	
	String findStudentNameById(int id);
	List<String> findStudentNames();
	
	Student findStudentById(int id);
	List<Student> findStudents();
}
