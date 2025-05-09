package com.mx.graphql.students.graphql;

public class InputStudent {

    private Long id;
    
    private String name;
    
    private String lastName;
    
    private Integer age;
    
    private String courseId;
    
	/**
	 * 
	 */
	public InputStudent() {
	}

	/**
	 * @param id
	 * @param name
	 * @param lastName
	 * @param age
	 * @param courseId
	 */
	public InputStudent(Long id, String name, String lastName, Integer age, String courseId) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.courseId = courseId;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return the courseId
	 */
	public String getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
    
    
}