package silsub1.run;

import silsub1.model.vo.Member;

public class Run {

	public static void main(String[] args) {
		Member mb = new Member();
		
		// setter�� �� ����
		mb.setMemberId("rrhak");
		mb.setMemberPwd("june2595!");
		mb.setMemberName("������");
		mb.setAge(26);
		mb.setGender('M');
		mb.setPhone("010-5129-8380");
		mb.setEmail("junewjdtn@gmail.com");
		
		// getter�� �� ��ȸ
		System.out.println("���̵�	: " + mb.getMemberId());
		System.out.println("��й�ȣ	: " + mb.getMemberPwd());
		System.out.println("����	: " + mb.getAge());
		System.out.println("����	: " + mb.getGender());
		System.out.println("��ȭ��ȣ	: " + mb.getPhone());
		System.out.println("�̸���	: " + mb.getEmail());
		
	}
}