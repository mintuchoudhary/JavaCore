package com.clone;

class CloneableTest implements Cloneable {

	private String name;

	public CloneableTest(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public CloneableTest clone() {
		try {
			return (CloneableTest) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void main(String[] args) {
		CloneableTest actualObj = new CloneableTest("Mintu");
		CloneableTest copyObj = actualObj; //reference to the same actual object
		copyObj.name = "A";  
		
		//Cloned
		CloneableTest cloneObj = actualObj.clone();
		cloneObj.name="B";
		
		System.out.println(cloneObj.getName());
		System.out.println(copyObj.getName());
	}
}