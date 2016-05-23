package com.fitness.data.services.dao.impl;

import java.util.List;
import java.util.ListIterator;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.fitness.data.core.model.Member;
import com.fitness.data.services.dao.MemberDAO;

@Component("memberDao")
public class MemberDAOImpl implements MemberDAO{

	private static SessionFactory factory;
	private static StandardServiceRegistryBuilder serviceRegistry;
	
	
	public List<Member> getMember(int memberId){
		Member member = null;
		Configuration conf = new Configuration().configure("hibernate.cfg.xml");
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
		factory = conf.buildSessionFactory(serviceRegistry.build());
		
		Session	session = factory.openSession();
		session.beginTransaction();
		List<Member> ls = session.createCriteria(Member.class).list();				
		session.getTransaction().commit();
		session.close();
		return ls;
	}
				
	public String createMember(Member member){
		
		member.setName(member.getName());
		member.setContactNo(member.getContactNo());
		member.setAddress(member.getAddress());
		
		try{
		Configuration conf = new Configuration().configure("hibernate.cfg.xml");
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
		factory = conf.buildSessionFactory(serviceRegistry.build());
		
		Session	session = factory.openSession();
		session.beginTransaction();
		session.save(member);
		session.getTransaction().commit();
		session.close();		
		}
		catch(HibernateException e){
			e.printStackTrace();
		}
		return "New Member id: " + member.getId() + " and " +member.getName()+ " has been created";
	}

	public String updateMember(Member member) {
				
		try{
			Configuration conf = new Configuration().configure("hibernate.cfg.xml");
			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
			factory = conf.buildSessionFactory(serviceRegistry.build());
			
			Session	session = factory.openSession();
			session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Member.class);
			Criterion criterion = Restrictions.eq("id", member.getId());
			criteria.add(criterion);
						
			List<Member> ls = criteria.list();
			ListIterator listIter = ls.listIterator();
			
			if (listIter.hasNext()){
				//Member localMember = new Member();
				
				member.setName(member.getName());
				member.setContactNo(member.getContactNo());
				member.setAddress(member.getAddress());
				
				session.update(member); 
			}
			else{
				System.out.println("There is no data with the Member id" +member.getId());
			}
			
			session.getTransaction().commit();
			session.close();		
			}
			catch(HibernateException e){
				e.printStackTrace();
			}
			return "New Member id: " + member.getId() + " and " +member.getName()+ " has been updated";
		
	}
}	