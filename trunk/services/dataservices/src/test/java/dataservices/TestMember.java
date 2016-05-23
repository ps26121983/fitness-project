package dataservices;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fitness.data.core.model.Member;
import com.fitness.data.services.MemberService;
import com.fitness.data.services.impl.MemberServiceImpl;


public class TestMember {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");			
		MemberService memberDao = (MemberService) context.getBean("memberservice");
		
		MemberService service = new MemberServiceImpl();
		//Member member = new Member();
	//	member.setId(1);
		//System.out.println("name" +member.getId());
		//dao.getMember(1);
		//member = dao.getMember(1);
		
		List<Member> member = service.getMember(1);
		//System.out.println("Member is:" + member.getName());
		
		//dao.createMember("Javid", 11, "AAA");
	}

}
