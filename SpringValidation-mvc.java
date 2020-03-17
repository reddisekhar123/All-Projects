SpringValidation-MVC
`````````````````````

**index.jsp**

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<font face="verdana" size="2">
<a href="displayForm.html">Login..</a>
</font>
</body>
</html>

***web.xml***

<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" id="WebApp_ID" version="2.5">
  <display-name>Validation-MVC</display-name>
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

<context:component-scan base-package="com.controller"></context:component-scan>

<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
<property name="prefix" value="/WEB-INF/Jsp/" />
<property name="suffix" value=".jsp"/>

</bean>

<bean id="messageSource" class="org.springframework.context.support.ResourceBundleMessageSource">
<property name="basename" value="props"></property>
</bean>
</beans>


****success.jsp***

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<style>
	table td{
		font-family:verdana;
		font-size:12px;
	}
</style>
</head>
<body>
<font face="verdana" size="2">Welcome<b>${lfobj.user}</b>,<br>
Validation Success..!<br><br>
<u>You Entered</u><br>
</font>

<table>
	<tr><td>Email</td><td>${lfobj.email}</td></tr>
	<tr><td>Phone</td><td>${lfobj.phone}</td></tr>
	

</table>
</body>
</html>


****loginPage.jsp****


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<style>
	table td{
		font-family:verdana;
		font-size:12px;
	}
</style>
</head>
<body>
<font face="verdana" size="2">Welcome<b>${lfobj.user}</b>,<br>
Validation Success..!<br><br>
<u>You Entered</u><br>
</font>

<table>
	<tr><td>Email</td><td>${lfobj.email}</td></tr>
	<tr><td>Phone</td><td>${lfobj.phone}</td></tr>
	

</table>
</body>
</html>


*****LoginController.java*****


package com.controller;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.bean.*;
@Controller
public class LoginController {

	@RequestMapping(value="displayForm",method=RequestMethod.GET)
	public String helloWorld(UserDetails ud) {
		return "loginPage";
	}
	@RequestMapping("/login")
	public String loginCheck(@Valid UserDetails userDetails,BindingResult result,ModelMap model) {
		
		if(result.hasErrors()) {
			return "loginPage";
		}
		else {
			model.addAttribute("lfobj", userDetails);
			return "success";
		}
	}
	
}



*****UserDetails.java*****


package com.bean;

public class UserDetails {

	private String user;
	private String email;
	private long phone;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
}