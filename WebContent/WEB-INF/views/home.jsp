<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css" media="screen">
        #editor {
           margin: 0;
        position: absolute;
        top: 0;
        bottom: 20%;
        left: 0;
        right: 0;
            
        }
        #part_line {
            margin:0;
            position: absolute;
            top: 80%;
            bottom: 16%;
            background-color:#2f3129;
            left: 0;
            right: 0;
        }
        #button {
            margin:0;
            position:absolute;
            top:0;
            bottom:0;
            background-color:#232323;
            left: 0;
            min-width: 40px
            
        }
        
        #run_png{
            margin:0;
            position:absolute;
            top:0;
            bottom:0;
            left: 3px;
            width: 30px
        }

        

        #console_label{
            margin:0;
            position:absolute;
            top:0;
            bottom:0;
            background-color:#ffffff;
            left: 40px;
            min-width: 80px
        }
        #console_label_text {
            margin:0;
            position:absolute;
            top:20%;
            bottom:0;
            left: 10%;
            right:0;
        }
        
        #label_rest {
            margin:0;
            position:absolute;
            top:96%;
            bottom:0;
            background-color:#ffffff;
            left: 80px;
            right:0;
        }

        #console {
            margin:0;
            position: absolute;
            top: 84%;
            right: 0;
            bottom: 0;
            left: 0;
        }

        
    </style>

<script>
function submit()
{
	
	var inputInfo= {
			"compiler_version":"clang 5.0.0(trunk)",
			"language":"c",
			"code_text":editor.getValue(),
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
	       console.setValue(obj.output);
	    }
	  }
	variable.send(JSON.stringify(inputInfo));
}
</script>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
   <pre id="editor">
#include &lt;stdio.h&gt;

void main()
{
    printf("hello,world!");
}
    </pre>
    <div id="part_line">
        <div id="button">
            <img id="run_png" src="resources/img/run_1.png" onclick="submit();"/>
        </div>
        <div id="console_label">
            <label id="console_label_text">
                <font color="#000000">
                    console
                </font>
            </label>
        </div>
        <div id="label_rest">
        </div>
    </div>
    <pre id="console">
hello,world!
    </pre>

    <script src="resources/arc/src-noconflict/ace.js" type="text/javascript" charset="utf-8"></script>
    <script>
    var editor = ace.edit("editor");
    editor.setTheme("ace/theme/twilight");
    editor.getSession().setMode("ace/mode/c_cpp");

    var console = ace.edit("console");
    console.setTheme("ace/theme/twilight");
    console.getSession().setMode("ace/mode/text");
    console.setReadOnly(true);
    </script>
</body>
</html>