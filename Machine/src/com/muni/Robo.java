package com.muni;

public class Robo {
	
	@Override
	public void finalize() {
		System.out.println(" finalize method has been invoked!!!");
	}
public static void main(String[] args) {
	System.out.println(" hello ");
	Robo robo = new Robo();
	robo = null;
	System.gc();
	
	String s = "hello";
	StringBuilder builder = new StringBuilder("hello");
	StringBuffer buffer = new StringBuffer("hello");
	
	s.concat("hi");
	builder.append(" hi");
	buffer.append(" hi");

	System.out.println(" new string is : "+s);
	System.out.println(" builder is : "+builder);
	System.out.println("buffer is : "+buffer);
	
	int N = 999999;
	long t;
	
	{
		StringBuffer b = new StringBuffer();
		t = System.currentTimeMillis();
		for(int i=N; i-->0;) {
			b.append(" ");
		}
		System.out.println(System.currentTimeMillis() - t);
	}
	
	

	{
		StringBuilder b = new StringBuilder();
		t = System.currentTimeMillis();
		for(int i=N; i-->0;) {
			b.append(" ");
		}
		System.out.println(System.currentTimeMillis() - t);
	}
	
	String s1 = "hello";
	String s4 = new String("hello");
	String s5 = new String("helo");
	String s3 = s1;
	String s2 = "helo";
	
	System.out.println(s1.equals(s4));

	System.out.println(" s1==s2 "+s1.equals(s2));
	
	Company one = new Company();
	one.setId("1000");
	one.setName("Deloitte");
	
	Company two = new Company();
	two.setId("1000");
	two.setName("Deloitte");
	
	Company three = two;
	
	System.out.println(three == one);
}
}
