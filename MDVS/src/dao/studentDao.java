package dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import beans.Student;
//DAO层前必须要加@Transactional
@Transactional	//教程没加，这个注解是否保留不确定
@Repository("studentDao")	////表示当前DAO的Bean的id为studentDao
public class studentDao implements IStudentDao 
{
	@Autowired	//byType方式自动注入
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void insertStudent(Student student) 
	{
		sessionFactory.getCurrentSession().save(student);
	}
	@Override
	public void deleteStudent(int id) 
	{
		Student stu = sessionFactory.getCurrentSession().get(Student.class,id);
		sessionFactory.getCurrentSession().remove(stu);
	}
	@Override
	public void updateStudent(Student student) 
	{
		sessionFactory.getCurrentSession().update(student);
	}
	@Override
	public String selectStudentNameById(int id) 
	{
		Student stu = sessionFactory.getCurrentSession().get(Student.class,id);
		if(stu != null)
		{
			return stu.getName();
		}
		return null;
	}
	@Override
	public List<String> selectStudentNames() 
	{
		String hql = "select name from Student";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}
	@Override
	public Student selectStudentById(int id) 
	{
		//return sessionFactory.getCurrentSession().load(Student.class,id);
		//load是延迟加载，返回的是空的代理
		return sessionFactory.getCurrentSession().get(Student.class,id);
	}
	@Override
	public List<Student> selectStudents() 
	{
		String hql = "select from Student";
		return sessionFactory.getCurrentSession().createQuery(hql).list();
	}
}
