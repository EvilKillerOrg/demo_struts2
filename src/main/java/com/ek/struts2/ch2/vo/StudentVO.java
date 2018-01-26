package com.ek.struts2.ch2.vo;

import java.util.List;

public class StudentVO {
	
	private String 	studentName;
	
	private List<LessonVO> lessonList;
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public List<LessonVO> getLessonList() {
		return lessonList;
	}
	public void setLessonList(List<LessonVO> lessonList) {
		this.lessonList = lessonList;
	}
	
	

}
