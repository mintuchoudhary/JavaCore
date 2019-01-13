package innerclass;


//Way1: Nested inner class
class Outer {
     int a=10;
	class Inner {
		void display() { // cannot have static method here as class needs to be static
			System.out.println("in display"+a);
		}
	}
}

// Way2: Method local inner class
//Note - Innter class
class Outer2 {
    int b=20;
	void outerMethod() {
		int c=30;
		System.out.println("in outer method 2");

		class Inner2 {
			void innerMethod() { // cannot have static method here as class needs to be static
				System.out.println("in inner method 2 "+b);
				System.out.println("in inner method 2 "+c);// till jdk 1.7 this would give error for non final variables
			}
		}
		new Inner2().innerMethod();
	}
}

//Way3: Static nested class
class Outer3
{
	static class Inner3 {
		public void innerMethod () {
			System.out.println("in inner method 3");
		}
	}
}
public class InnerClass {
	public static void main(String[] args) {
		Outer.Inner obj = new Outer().new Inner();
		obj.display();
	
	    //Way2: Method local inner class
		Outer2 obj2= new Outer2();
		obj2.outerMethod();

		//Way3: Static inner class
    	Outer3.Inner3 obj3 = new Outer3.Inner3();
	    obj3.innerMethod();
	}
}
