package Test;

public class Souter {
	private int a=1;
	static int b=2;
	public static class Sinner{
	int b =3;
	public void test(){
		System.out.println("�����ⲿ���е�b��"+Souter.b);
		System.out.println("�����ڲ����е�b��"+b);
	}
}
	public static void main(String[] args){
		Sinner sin = new Sinner();
		sin.test();
	}
}
