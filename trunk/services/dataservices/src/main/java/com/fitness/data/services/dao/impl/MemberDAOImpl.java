package com.fitness.data.services.dao.impl;

import java.util.List;
import java.util.ListIterator;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
	
	
	public SessionFactory getSessionFactory(){
		Configuration conf = new Configuration().configure("hibernate.cfg.xml");
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
		factory = conf.buildSessionFactory(serviceRegistry.build());
		return factory;
	}
	
	public List<Member> getMember(int memberId){		
		
		
		Session	session = this.getSessionFactory().openSession();
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
		Session	session = this.getSessionFactory().openSession();
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
			Transaction tx = null;
			Session	session = this.getSessionFactory().openSession();
			tx = session.beginTransaction();
			Member localMember = (Member) session.get(Member.class, member.getId());						
			if (localMember != null){								
				localMember.setName(member.getName());
				localMember.setContactNo(member.getContactNo());
				localMember.setAddress(member.getAddress());				
				session.update(localMember);
				tx.commit();
			}
			else{
				System.out.println("There is no data with the Member id" +member.getId());
			}			
			session.close();		
			}
			catch(HibernateException e){
				e.printStackTrace();
			}
			return "New Member id: " + member.getId() + " and " +member.getName()+ " has been updated";
		
	}
}	