package com.clone;

/**
Deep copy is preferred if an object has references to other objects as fields.
*/
class Address {
	String city;
	String desc;

	public Address(String city, String desc) {
		super();
		this.city = city;
		this.desc = desc;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}

class Employee implements Cloneable {
	int empId;
	String name;
	Address add;

	public Employee(int empId, String name, Address add) {
		super();
		this.empId = empId;
		this.name = name;
		this.add = add;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAdd() {
		return add;
	}

	public void setAdd(Address add) {
		this.add = add;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Employee emp = (Employee) super.clone();
		//NOTE: here the same previous object has to be set so the original object doesnt change
		Address add= new Address(emp.getAdd().getCity(), emp.getAdd().getDesc());
	    emp.setAdd(add);
	    	
			//Address add = new Address(this.getAdd().city,this.getAdd().desc);
			
		return emp;
	}
}

public class DeepCloning {
	public static void main(String[] args) throws CloneNotSupportedException {
		Address add = new Address("Pune", "Best city");
		Employee emp = new Employee(101, "Mintu", add);
		Employee emp2 = (Employee) emp.clone();
		emp2.getAdd().setCity("Mumbai");  
		//This should not change the original object emp, should only reflect in emp2 but it is not so
		//To achieve this we need to apply deep cloning logic in clone() method
		emp2.getAdd().setDesc("best Sea side view");
	 	System.out.println(emp.getEmpId()+" "+emp.getName() +" "+emp.getAdd().city +" "+emp.getAdd().getDesc());
		
		System.out.println(emp2.getEmpId()+" "+emp2.getName() +" "+emp2.getAdd().city +" "+emp2.getAdd().getDesc());
	
	}
}
