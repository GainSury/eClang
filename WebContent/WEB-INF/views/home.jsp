<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script>

function submit()
{
	var code = document.getElementById("code").value;
	var inputInfo= {
			"compiler_version":"clang 5.0.0(trunk)",
			"language":"c",
			"code_text":document.getElementById("code").value,
			"compiler_option":null};
// document.getElementById("code").value;
	variable=new XMLHttpRequest();
	variable.open("post","compileAndOutput",true);
	variable.setRequestHeader("Content-type","application/json; charset=utf-8");
	variable.onreadystatechange=function(output)
	  {
	  if (variable.readyState==4 && variable.status==200)
	    {
	        
	       var obj = JSON.parse(variable.responseText);
	       document.getElementById("status").innerHTML = obj.status;
	       document.getElementById("output").value = obj.output;
	    }
	  }
	variable.send(JSON.stringify(inputInfo));
}
</script>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
	<textarea rows="10" cols="50" id="code">
点击这里提交代码
</textarea>
 <div></div>
<button type="button" onclick="submit()">提交</button>
 <div></div>
 <label for="female" id="status">状态</label>
 <div></div>
  <textarea  rows="10" cols="50"id="output">结果</textarea>
</body>
</html>