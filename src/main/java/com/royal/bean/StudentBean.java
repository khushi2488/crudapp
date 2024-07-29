package com.royal.bean;

import java.util.ArrayList;

public class StudentBean {
 private int rno;
 private String name;
 private String std;
 private String marks;
 private ArrayList<String> hobbies;
   public StudentBean() {
	   
   }
public StudentBean(int rno, String name, String std, String marks,ArrayList<String> hobbies) {
	super();
	this.rno = rno;
	this.name = name;
	this.std = std;
	this.marks = marks;
	this.hobbies = hobbies;
}
public int getRno() {
	return rno;
}
public void setRno(int rno) {
	this.rno = rno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getStd() {
	return std;
}
public void setStd(String std) {
	this.std = std;
}
public String getMarks() {
	return marks;
}
public void setMarks(String marks) {
	this.marks = marks;
}
public ArrayList<String> getHobbies() {
    return hobbies;
}

public void setHobbies(ArrayList<String> hobbies) {
    this.hobbies = hobbies;
}

}
