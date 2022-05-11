package singleton;

public class SingletonMain {

	public static void main(String[] args) {
		// 객체 생성
		// [1] : 생성자가 private
		// Singleton singleton = new Singleton();
		
		// [2]
		//Singleton singleton1 = Singleton.getInstance();
		//Singleton singleton2 = Singleton.getInstance();
		//System.out.println(singleton1 == singleton2);
		// 실행 될때마다 새로운 객체를 만들어 주기 때문에 주소 값이 다름
		
		// [3]
		Singleton singleton1 = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		System.out.println(singleton1 == singleton2);
	}
}