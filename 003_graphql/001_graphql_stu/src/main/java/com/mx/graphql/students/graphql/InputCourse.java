package com.mx.graphql.students.graphql;

public class InputCourse {

    private String name;
    
    private String category;
    
    private String teacher;
    
	/**
	 * 
	 */
	public InputCourse() {
	}

	/**
	 * @param name
	 * @param category
	 * @param teacher
	 */
	public InputCourse(String name, String category, String teacher) {
		this.name = name;
		this.category = category;
		this.teacher = teacher;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the teacher
	 */
	public String getTeacher() {
		return teacher;
	}

	/**
	 * @param teacher the teacher to set
	 */
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
    
    
}
