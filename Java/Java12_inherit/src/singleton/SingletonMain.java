package singleton;

public class SingletonMain {

	public static void main(String[] args) {
		// ��ü ����
		// [1] : �����ڰ� private
		// Singleton singleton = new Singleton();
		
		// [2]
		//Singleton singleton1 = Singleton.getInstance();
		//Singleton singleton2 = Singleton.getInstance();
		//System.out.println(singleton1 == singleton2);
		// ���� �ɶ����� ���ο� ��ü�� ����� �ֱ� ������ �ּ� ���� �ٸ�
		
		// [3]
		Singleton singleton1 = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		System.out.println(singleton1 == singleton2);
	}
}