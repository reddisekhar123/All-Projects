****index.jsp*****


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="empform">Add Employee</a>
<a href="viewmap">View Employees</a>
</body>
</html>


****web.xml***

<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" id="WebApp_ID" version="2.5">
  <display-name>Jdbc-Mvc</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>
  
  
   <servlet>
  <servlet-name>spring</servlet-name>
  <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
  <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
  <servlet-name>spring</servlet-name>
  <url-pattern>/</url-pattern>
  </servlet-mapping>
  
</web-app>


****spring-servlet.xml****


<?xml version="1.0" encoding="UTF-8"?>
<beans
 xmlns="http://www.springframework.org/schema/beans"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xmlns:p="http://www.springframework.org/schema/com.controller"
xmlns:context="http://www.springframework.org/schema/context"
xsi:schemaLocation="http://www.springframework.org/schema/beans
http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
http://www.springframework.org/schema/context
http://www.springframework.org/schema/context/spring-context-3.0.xsd">

<context:component-scan base-package="com.crud.controller"></context:component-scan>

<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
<property name="prefix" value="/WEB-INF/Jsp/" />
<property name="suffix" value=".jsp"/>

</bean>

<bean id="ds" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
<property name="driverClassName" value="com.mysql.jdbc.Driver"></property>
<property name="url" value="jdbc:mysql://localhost:3306/practise"></property>
<property name="username" value="root"></property>
<property name="password" value="root"></property>

</bean>
<bean id="jt" class="org.springframework.jdbc.core.JdbcTemplate">
<property name="dataSource" ref="ds"></property>
</bean>
<bean id="dao" class="com.crud.dao.EmpDAO">
<property name="template" ref="jt"></property>
</bean>
</beans>


****empeditform.jsp****


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Edit Employee</h1>
<form:form method="POST" action="/Jdbc-Mvc/editsave">
<table>
<tr>
		<td></td>
		<td><form:hidden path="id"/></td>
</tr>

<tr>
		<td>Name:</td>
		<td><form:input path="name"/></td>
</tr>

<tr>
		<td>Salary:</td>
		<td><form:input path="salary"/></td>
</tr>	

<tr>
		<td>Designation:</td>
		<td><form:input path="designation"/></td>
</tr>	

<tr>
		<td></td>
		<td><input type="submit" value="Edit Save"/></td>
</tr>		
		
</table>
</form:form>
</form>
</body>
</html>


****empform.jsp****


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>

<body>
<h1>Add New Employee</h1>
<form:form method="post" action="save">
<table>
<tr>
<td>Name:</td>
<td><form:input path="name"/></td>
</tr>

<tr>
<td>Salary:</td>
<td><form:input path="salary"/></td>
</tr>

<tr>
<td>Designation:</td>
<td><form:input path="designation"/></td>
</tr>

<tr>
<td></td>
<td><input type="submit" value="Save">
</td>
</tr>
</table>
</form:form>
</body>
</html>


****viewmap.jsp***

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Employees List</h1>
<table border="2" width="70%" cellpadding="2">
<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Salary</th>
		<th>Designation</th>
		<th>Edit</th>
		<th>Delete</th>
</tr>
<c:forEach var="emp" items="${list}">
<tr>
		<td>${emp.id}</td>
		<td>${emp.name}</td>
		<td>${emp.salary}</td>

		<td>${emp.designation}</td>
		<td><a href="editemp/${emp.id}">Edit</a></td>
		<td><a href="deleteemp/${emp.id}">Delete</a></td>
</tr>
</c:forEach>
</table>
<br/>
<a href="empform">Add New Employee</a>
</body>
</html>


****Emp.java***

package com.crud.bean;

public class Emp {

	private int id;
	private String name;
	private float salary;
	private String designation;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
}



****EmpController.java****


package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import com.crud.bean.Emp;
import com.crud.dao.EmpDAO;
@Controller
public class EmpController {
@Autowired
EmpDAO dao;

@RequestMapping("/empform")
public  ModelAndView showform() {
	return new ModelAndView("empform","command",new Emp());
}


	@RequestMapping(value="/save",method=RequestMethod.POST)
	public  ModelAndView save(@ModelAttribute("emp")Emp emp){
		dao.save(emp);
		return new ModelAndView("redirect:/viewmap");
	}
	@RequestMapping("/viewmap")
	public  ModelAndView viewemp() {
		List<Emp> list=dao.getEmployees();
		return new  ModelAndView("viewmap","list",list);
	}
		@RequestMapping(value="/editemp/{id}")
		public  ModelAndView edit(@PathVariable int id) {
			Emp emp=dao.getEmpById(id);
			return new  ModelAndView("empeditform","command",emp);
		}
		
		@RequestMapping(value="/editsave",method=RequestMethod.POST)
		
		public ModelAndView editsave(@ModelAttribute("emp")Emp emp) {
			dao.update(emp);
			return new ModelAndView("redirect:/viewmap");
		}
		@RequestMapping(value="/deleteemp/{id}",method=RequestMethod.GET)
		public ModelAndView delete(@PathVariable int id) {
			dao.delete(id);
			return new ModelAndView("redirect:/viewmap");
		}

	
}




*****EmpDAO.java****


package com.crud.dao;
import java.sql.*;
import java.util.List;
import org.springframework.jdbc.core.*;
import com.crud.bean.Emp;
public class EmpDAO {

	JdbcTemplate template;
	static int number;
	int minimum=1;
	int maximum=5000;
	public EmpDAO() {
		number=minimum+(int)(Math.random()*maximum);
	}
	public void setTemplate(JdbcTemplate template) {
		this.template=template;
	}
	public int save(Emp p) {
		number++;
		String sql="insert into Emp99 values("+number+",";
		sql=sql+"'"+p.getName()+"',"+p.getSalary()+",'"+p.getDesignation()+"')";
		return template.update(sql);
	}
	public int update(Emp p) {
		
		String sql="update Emp99 set name='"+p.getName()+"',salary="+p.getSalary()+",designation='"+p.getDesignation()+"'where id="+p.getId()+"";
		
		
		return template.update(sql);
	}
	public int delete(int id) {
		String sql="delete from Emp99 where id="+id+"";
		return template.update(sql);

	}
	public Emp getEmpById(int id) {
		String sql="select * from Emp99 where id=?";
		return template.queryForObject(sql,new Object[] {id},new BeanPropertyRowMapper<Emp>(Emp.class));

	}
	public List<Emp> getEmployees(){
		return template.query("select * from Emp99",new RowMapper<Emp>() {
			public Emp mapRow(ResultSet rs,int row)throws SQLException{
				Emp e=new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getFloat(3));
				e.setDesignation(rs.getString(4));
				return e;
					
			}
		});
	}
	
	
}
