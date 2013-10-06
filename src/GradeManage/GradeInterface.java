package GradeManage;

import java.util.HashMap;
import java.util.List;

import DB.UserBean;

public interface GradeInterface {
	public int oneChoice(UserBean userbean);
	public List<?> getAllist();
	public boolean changeOnecourse(CourseBean coursebean);
	public List<?> getAllGrade();

}
