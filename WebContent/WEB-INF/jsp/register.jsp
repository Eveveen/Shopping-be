<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <title>用户注册</title>
    <link type="text/css" rel="stylesheet" href="resource/css/framework.css" />
    <link type="text/css" rel="stylesheet" href="resource/css/main.css" />

	<link type="text/css" rel="stylesheet" href="resource/css/global.css">
	<link type="text/css" rel="stylesheet" href="resource/css/register.css">
</head>
<body>
<div class="page">
<!--header begin-->
	<header>
		<div class="bigcontainer">
			<div id="logo">
				<a href="./">GeekLink用户中心</a>
			</div>
		</div>
	</header>

<!--the main content begin-->
	<div id="banner" class="short">
		<div class="inset">
			<h1>用户注册</h1>
			<p>Connect the real world and the internet world!</p>
		</div>
	</div>

	<div id="body">
		<div id="reg_frmbox">
			<form id="frm_register" accept-charset="UTF-8" action="toRegister" class="frm_reg" name="form" method="post">
				<div style="margin:0;padding:0;display:inline">
					<input name="key" type="hidden" value="e454a358be090e864c4df72451758b03">
				</div>

				<fieldset>
					<div id="validateCodeErrMsg" style="color:red"></div>
					<div class="control-group">
						<label class="control-label" for="username">用户名</label>
						<div class="controls">
							<input id="user_name" name="name" size="30" type="text" value="" style="background-attachment: scroll; background-size: 16px 18px; background-position: 98% 50%;">
							<span id="usernameMsg" style="color:red"></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="email">电子邮件</label>
						<div class="controls">
							<input id="email" name="email" size="30" type="text" value="">
							<span id="emailMsg" style="color:red"></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="password">密码</label>
						<div class="controls">
							<input id="passwd" name="password" size="30" type="password" style=" background-attachment: scroll; background-size: 16px 18px; background-position: 98% 50%;">
							<span id="passwordMsg" style="color:red"></span>
						</div>
					</div>
					<div class="control-group ">
						<label class="control-label" for="password1">确认密码</label>
						<div class="controls">
							<input id="repassword" name="password1" size="30" type="password" style=" background-attachment: scroll; background-size: 16px 18px; background-position: 98% 50%;">
							<span id="repasswordMsg" style="color:red"></span>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="validate_code">验证码</label>
						<div class="controls">
							<!-- <img id="validata_img" src="resource/other/captcha.jpg" >  -->
							<a href="#" id="changeImg">
							    <canvas class="show-captcha" id="canvas" width="150" height="40"></canvas>
							</a>
							<a id="change_validate_code" href="javascript:void(0);">看不清楚？再换一张</a>
						</div>
						<div class="controls">
							<input id="validate_code" name="validate_code" size="30" type="text" style="width:80px;">
							<span id="validateCodeMsg" style="color:red"></span>
						</div>
					</div>

					<div class="form-actions">
						<p><input id="cb_clause" type="checkbox" checked="checked"> 我已经仔细阅读并同意《服务条款》中的相关事项。</p>
						<button class="btn-primary btn" name="commit" type="submit" value="注册 GeekLink 帐号"> 注册GeekLink帐号</button>
					</div>
				</fieldset>
			</form>

		</div>
		<div class="side_box">
			<h2>帐号与您的设备</h2>
			<p>
				感谢您的关注并准备注册为GeekLink用户。
			</p>
			<p>
				作为一家传感器云网络提供商，我们致力于将您身边的物体接入互联网，并使您能方便地通过互联网或者移动设备了解他们的状态、控制他们。除了我们提供的硬件设备外，您也可以设计自己的传感器硬件，并通过开放API免费接入。
			</p>

		</div>
	</div>




</div>  <!--page-->
<!--footer begin-->
<footer>
	<div id="copyrights">
		<div class="inset">
			<div class="bigcontainer">
				<div class="fl">
					<div class="logo"></div>
					<p>&copy; 2020 南通极客信息技术有限公司, 版权所有<br />
<a href="http://www.boode.com.cn" target="_blank">苏ICP备13024285号</a></p>
				</div>
			</div>
		</div>
	</div>
</footer>

<script type="text/javascript" src="resource/javascript/jquery.min.js"></script>
<script type="text/javascript" src="resource/javascript/framework.js"></script>
<script type="text/javascript" src="resource/javascript/jquery.zclip.min.js"></script>
<script type="text/javascript" src="resource/javascript/alert.js"></script>
<script>
	$(document).ready(function(){
		$('a#copy-apiKey').zclip({
			path:'resource/javascript/ZeroClipboard.swf',
			copy:function(){return $('input#apiKey').val();}
		});

		$('.ui.dropdown')
			.dropdown();
		
		
		/**生成一个随机数**/
	    function randomNum(min, max) {
	        return Math.floor(Math.random() * (max - min) + min);
	    }
	    /**生成一个随机色**/
	    function randomColor(min, max) {
	        var r = randomNum(min, max);
	        var g = randomNum(min, max);
	        var b= randomNum(min, max);
	        return "rgb(" + r + "," + g + "," + b + ")";
	    }
	    var code=drawPic();
	    document.getElementById("changeImg").onclick = function(e) {
	        e.preventDefault();
	        code=drawPic();
	    }
	    /**绘制验证码图片**/
	    function drawPic() {
	        var canvas = document.getElementById("canvas");
	        var width = canvas.width;
	        var height = canvas.height;
	        //获取该canvas的2D绘图环境 
	        var ctx = canvas.getContext('2d'); 
	        ctx.textBaseline ='bottom';
	        /**绘制背景色**/
	        ctx.fillStyle = randomColor(180,240);
	        //颜色若太深可能导致看不清
	        ctx.fillRect(0,0,width,height);
	        /**绘制文字**/
	        var str ="ABCEFGHJKLMNPQRSTWXY123456789";
	　　　　	var code="";
　　　　		//生成四个验证码
	        for(var i=1;i<=4;i++) {
	            var txt = str[randomNum(0,str.length)];
	            code=code+txt;
	            ctx.fillStyle = randomColor(50,160);
	            //随机生成字体颜色
	            ctx.font = randomNum(15,40) +'px SimHei';
	            //随机生成字体大小
	            var x =10 +i *25;
	            var y = randomNum(25,35);
	            var deg = randomNum(-45,45);
	            //修改坐标原点和旋转角度
	            ctx.translate(x, y); 
	            ctx.rotate(deg * Math.PI /180); 
	            ctx.fillText(txt,0,0);
	            //恢复坐标原点和旋转角度
	            ctx.rotate(-deg * Math.PI /180);
	            ctx.translate(-x, -y);
	        }
	        
	        /**绘制干扰线**/
	        for(var i=0;i<3;i++) {
	            ctx.strokeStyle = randomColor(40, 180);
	            ctx.beginPath();
	            ctx.moveTo(randomNum(0,width/2), randomNum(0,height/2));
	            ctx.lineTo(randomNum(0,width/2), randomNum(0,height));
	            ctx.stroke();
	        }
	        /**绘制干扰点**/
	        for(var i=0;i <50;i++) {
	            ctx.fillStyle = randomColor(255);
	            ctx.beginPath();
	            ctx.arc(randomNum(0, width), randomNum(0, height),1,0,2* Math.PI);
	            ctx.fill();
	        }
	        return code;
	    }
	    
	    $("#change_validate_code").click(function(e){
	    	console.log("change,");
	    	 e.preventDefault();
		     code=drawPic();
	    });
		
		$("#user_name").blur(function(){
			
			var username = $(this).val();
			if(username == ""){
				
				$("#usernameMsg").html("用户名不能为空");
			}else if(username.length > 10){
				
				$("#usernameMsg").html("用户名长度不能大于10");
			}else{
				
				$.ajax({
					
					url:"ajax",
					data:"username="+$("#user_name").val(),
					type:"post",
					success:function(data){
						
						console.log(data);
						if(data =="1"){
							
							$("#usernameMsg").html("此用户名已存在");
						}else{
							
							$("#usernameMsg").html("");	
						}
					}
				});
				
			}
		});
		
        $("#email").blur(function(){
			
			var email = $(this).val(); 
			var reg = /^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\.[a-zA-Z0-9]+)+$/;
			
			if(email == ""){
				
				$("#emailMsg").html("电子邮箱不能为空");
			}else if(!reg.test(email)){
				
				$("#emailMsg").html("电子邮箱格式错误");
			}else{
				
				$("#emailMsg").html("");
			}
		});
        
    	$("#passwd").blur(function(){
			
			var password = $(this).val();
			if(password == ""){
				
				$("#passwordMsg").html("密码不能为空");
			}else if(password.length > 20){
				
				$("#passwordMsg").html("密码长度不能大于20");
			}else{
				
				$("#passwordMsg").html("");
			}
		});
    	
		$("#repassword").blur(function(){
			
			var repassword = $(this).val();
			var password = $("#passwd").val();
			if(repassword == ""){
				
				$("#repasswordMsg").html("确认密码不能为空");
			}else if(repassword == password){
				
				$("#repasswordMsg").html("");
			}else{
				
				$("#repasswordMsg").html("两次输入的密码不一致");
			}
		});
		
		$("#validate_code").blur(function(){
			
			var validateCode = $(this).val();
			if(validateCode == ""){
				
				$("#validateCodeMsg").html("验证码不能为空");
			}else{
				
				$("#validateCodeMsg").html("");
			}
		});
		
		$("form").submit(function(){
			
			var username = $("#user_name").val();
			var email = $("#email").val();
			var password = $("#passwd").val();
			var repassword = $("#repassword").val();
			var validateCode = $("#validate_code").val();
				
			if(username == ""){
				
				$("#usernameMsg").html("用户名不能为空");
				//e.preventDefault();
				return false;
			}else if(email == ""){
				
				$("#emailMsg").html("电子邮箱不能为空");
				//e.preventDefault();
				return false;
			}else if(password == ""){
				
				$("#passwordMsg").html("密码不能为空");
				//e.preventDefault();
				return false;
			}else if(repassword == ""){
				
				$("#repasswordMsg").html("确认密码不能为空");
				//e.preventDefault();
				return false;
			}else if(validateCode == ""){
				 
				$("#validateCodeMsg").html("验证码不能为空");
				//e.preventDefault();
				return false;
			} else if(validateCode != code){
				$("#validateCodeErrMsg").html("验证码不正确");
				return false;
			} else if($("#usernameMsg").html() != "" || 
					 $("#emailMsg").html() != "" || 
					 $("#passwordMsg").html() != "" || 
					 $("#repasswordMsg").html() != "" || 
					 $("#repasswordMsg").html() != "" || 
					 $("#validateCodeMsg").html() != ""){
				
				return false;
			}else if($('#cb_clause').is(":checked")){
				
				return true;
			}else{
				
				//console.log($("#cb_clause").is(":checked"));获取checkbox是否被选中
				alert("您必须同意《服务条款》才能完成注册");
				return false;
			}
		});
	});
</script>
</body>
</html>
