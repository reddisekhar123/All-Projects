<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
Map map=new HashMap();
map.put("name","Tim");
map.put("address","200,Saint Thomas Loop");
map.put("state","Virginia,USA");
request.setAttribbute("useMap",map);
%>
<body>
<center>
<table>
<tr><td><b>The first element in the map is:</td></b><td><b>${useMap["name"]}</td></tr></b><br>
<tr><td><b>The second element in the map is:</td></b><td><b>${useMap["name"]}</tr></td></b><br>
</table>
</center>
</body>
</html>