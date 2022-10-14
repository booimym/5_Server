package edu.kh.jsp.model.vo;

public class Person {

	//필드
	private String name;
	private int age;
	private String address;
	
	public Person() { //기본 생성자
		
	}
	
	
	
	public Person(String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}



	//getter/setter
	public void setName(String name) {
	 this.name= name;	
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age= age;
	}
	public int getAge() {
		return age;
	}
	public void setAddress(String address) {
		this.address= address;
	}
	public String getAddress() {
		return address;
	}

	//Object.toString()을 오버라이딩
	@Override
	public String toString() {
		return name +  " / " + age + " / " + address ;
	}


	
	
	
	
}
