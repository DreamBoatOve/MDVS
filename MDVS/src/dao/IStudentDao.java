package dao;

import java.util.List;

import beans.Student;

public interface IStudentDao 
{
	public void insertStudent(Student student);
	public void deleteStudent(int id);
	public void updateStudent(Student student);
	public String selectStudentNameById(int id);
	public List<String> selectStudentNames();
	public Student selectStudentById(int id);
	public List<Student> selectStudents();
}
