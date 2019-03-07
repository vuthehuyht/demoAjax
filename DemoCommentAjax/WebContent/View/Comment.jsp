  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Comment Page</title>
<script type="text/javascript">
	function display() {
		var xhttp;
		var username = document.demo.username.value;  
		var commentContent = document.demo.commentContent.value; 
		var url = "CommentController?content="+commentContent+"&username="+username; 
		if(window.XMLHttpRequest){
			xhttp = new XMLHttpRequest();
		} else {
			xhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xhttp.onreadystatechange = function () {
			if(xhttp.readyState == 4){
				var data = xhttp.responseText;
				document.getElementById("comments").innerHTML = data;
			}
		}
		xhttp.open("post", url, true);
		xhttp.send();
	}
</script>
</head>
<body>
	<form name="demo">
		Username: <input type="text" name="username">
		<br>
		<br>
		<textarea style="width: 300px; height: 100px;" name="commentContent">
		</textarea>
		<br>
		<br>
		<input type="button" value="Post" onclick="display()">
	</form>
	<dir id="comments"></dir>
</body>
</html>