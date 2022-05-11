package silsub1.run;

import silsub1.model.vo.Member;

public class Run {

	public static void main(String[] args) {
		Member mb = new Member();
		
		// setter로 값 변경
		mb.setMemberId("rrhak");
		mb.setMemberPwd("june2595!");
		mb.setMemberName("임정수");
		mb.setAge(26);
		mb.setGender('M');
		mb.setPhone("010-5129-8380");
		mb.setEmail("junewjdtn@gmail.com");
		
		// getter로 값 조회
		System.out.println("아이디	: " + mb.getMemberId());
		System.out.println("비밀번호	: " + mb.getMemberPwd());
		System.out.println("나이	: " + mb.getAge());
		System.out.println("성별	: " + mb.getGender());
		System.out.println("전화번호	: " + mb.getPhone());
		System.out.println("이메일	: " + mb.getEmail());
		
	}
}