package com.ek.struts2.ch2.action;

import java.util.ArrayList;
import java.util.List;

import com.ek.struts2.ch2.vo.LessonVO;
import com.ek.struts2.ch2.vo.StudentVO;

public class OgnlAction {
	private StudentVO  studentVO;
 
	public StudentVO getStudentVO() {
		return studentVO;
	}
	public void setStudentVO(StudentVO studentVO) {
		this.studentVO = studentVO;
	}



	
	public String execute() throws Exception {
		
		LessonVO lessonVO1 = new LessonVO();
		lessonVO1.setLessonName("OGNL");
		lessonVO1.setHours(8);
		
		LessonVO lessonVO2 = new LessonVO();
		lessonVO2.setLessonName("STRUTS2");
		lessonVO2.setHours(11);
		
		List<LessonVO> lessonList = new ArrayList<LessonVO>();
		lessonList.add(lessonVO1);
		lessonList.add(lessonVO2);
		
		studentVO = new StudentVO();
		studentVO.setStudentName("kkk");
		studentVO.setLessonList(lessonList);
		
		return "input";
	}
				
}
