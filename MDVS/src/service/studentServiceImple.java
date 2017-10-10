package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import beans.Student;
import dao.IStudentDao;


@Service("studentService")	//表示当前Service的Bean的id为studentService
public class studentServiceImple implements IStudentService 
{
	@Resource	//byType方式注入
	private IStudentDao dao;
	public IStudentDao getDao() 
	{
		return dao;
	}
	public void setDao(IStudentDao dao) 
	{
		this.dao = dao;
	}
	@Transactional
	@Override
	public void addStudent(Student stu) 
	{
		dao.insertStudent(stu);
	}
	@Transactional
	@Override
	public void removeStudent(int id) 
	{
		dao.deleteStudent(id);
	}
	@Transactional
	@Override
	public void modifyStudent(Student stu) 
	{
		dao.updateStudent(stu);
	}
	@Transactional(readOnly=true)
	@Override
	public String findStudentNameById(int id) 
	{
		return dao.selectStudentNameById(id);
	}
	@Transactional(readOnly=true)
	@Override
	public List<String> findStudentNames() 
	{
		return dao.selectStudentNames();
	}
	@Transactional(readOnly=true)
	@Override
	public Student findStudentById(int id) 
	{
		return dao.selectStudentById(id);
	}
	@Transactional(readOnly=true)
	@Override
	public List<Student> findStudents() 
	{
		return dao.selectStudents();
	}
}
