<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
     <meta name="renderer" content="webkit">
    <title>修改密码 | GeekLink用户中心</title>
    <link type="text/css" rel="stylesheet" href="resource/css/framework.css" />
    <link type="text/css" rel="stylesheet" href="resource/css/main.css" />
</head>
<body>
<div class="page">
<!--header begin-->
	<header>
		<div class="bigcontainer">
			<div id="logo">
				<a href="./">管理首页</a>
			</div>
			<div class="user">
				<div class="ui compact notif menu">
					<a class="item" href="indexTonotifications/${user.userId }">
						<i class="mail large icon"></i>
						${count==0 ? "" : '<span class="circular floating ui small red label">' + count + '</span>' }
					</a>
				</div>
				<div class="ui inline labeled icon top right pointing dropdown">
					<img class="ui avatar image" src="resource/images/avatar-default.gif">
					欢迎，${user.name }
					<i class="dropdown icon"></i>
					<div class="menu">
						<a class="item" href="index"><i class="reply mail icon"></i>返回首页</a>
						<a class="item" href="login"><i class="sign out icon"></i>注销</a>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- the main menu-->
	<div class="ui teal inverted menu">
		<div class="bigcontainer">
			<div class="right menu">
				<a class="item" href="./index"><i class="home icon"></i>管理首页</a>
				<a class="item" href="./devices_list"><i class="sitemap icon"></i>设备</a>
				<a class="active item" href="./indexToUserProfile"><i class="info icon"></i>账户</a>
			</div>
		</div>
	</div>
<!--the main content begin-->
	<div class="container">
	<!--the content-->
		<div class="ui grid">
			<!--the vertical menu-->
			<div class="four wide column">
				<div class="verticalMenu">
					<div class="ui vertical pointing menu fluid">
  						<a class="item" href="./indexToUserProfile">
							<i class="edit icon"></i>账户设置
  						</a>

  						<a class="active teal item" href="./change_password">
    						<i class="lock icon"></i> 修改密码
  						</a>

						<a class="item" href="./indexTonotifications/${user.userId }">
							<i class="chat icon"></i> 我的消息
						</a>
					</div>
				</div>
			</div>
			<div class="twelve wide column">
				<div class="pageHeader">
					<div class="segment">
						<h3 class="ui dividing  header">
  							<i class="large unlock alternate icon"></i>
  							<div class="content">
    							修改密码
  							</div>
						</h3>
					</div>
				</div>
				<!--the form-->
                <form class="ui form vertical segment" action="change_password/editUser" name="form" method="post">
                    <div class="two fields">
                        <div class="field">
                            <label>原密码</label>
                            <div class="ui small left icon input">
                              <input type="password" id="password" name="pwd" size="30">
                              <i class="lock icon"></i>
                            </div>
                            <span id="passwordMsg" style="color:red"></span>
                        </div>
                    </div>
                    <div class="two fields">
                    	<div class="field">
                        	<label>新密码</label>
                            <div class="ui small left icon input">
                            	<input type="password" id="password1" name="password" size="30">
                                <i class="lock icon"></i>
                            </div>
                            <span id="password1Msg" style="color:red"></span>
                        </div>
                    </div>
                    <div class="two fields">
                    	<div class="field">
                        	<label>确认新密码</label>
                            <div class="ui small left icon input">
                            	<input type="password" id="password2" name="password2" size="30">
                                <i class="lock icon"></i>
                            </div>
                            <span id="password2Msg" style="color:red"></span>
                        </div>
                    </div>
                    <input class="ui small blue submit button" type="submit" value="保存">
                    <input class="ui small basic button" type="reset" value="取消">
                </form>
                <input id="userPwd" type="hidden" value="${user.password }">
			</div>
		</div>
	</div>

</div>
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
<script type="text/javascript">
	$('.ui.dropdown')
	.dropdown();

	$("form").submit(function(){
		
		var password = $("#password").val();
		var password1 = $("#password1").val();
		var password2 = $("#password2").val();
		console.log("userPwd",$("#userPwd").val());
		$("#password").blur(function(){
			console.log("password,",$("#password").val());
			if(password != null){				
				$("#passwordMsg").html("");
			}
		});
		$("#password1").blur(function(){
			if(password1 != null){				
				$("#password1Msg").html("");
			}
		});
		$("#password2").blur(function(){
			if(password2 != null){				
				$("#password2Msg").html("");
			}
		});
			
		if(password == ""){
			
			$("#passwordMsg").html("原密码不能为空");
			return false;
		}else if(password1 == ""){
			
			$("#password1Msg").html("新密码不能为空");
			return false;
		}else if(password2 == ""){
			 
			$("#password2Msg").html("确认新密码不能为空");
			//e.preventDefault();
			return false;
		} else if($("#passwordMsg").html() != "" || 
				 $("#password1Msg").html() != "" || 
				 $("#password2Msg").html() != "" ){
			
			return false;
		} else if(password1 != password2) {
			$("#password2Msg").html("确认密码不一致");
			return false;
		} else if($("#userPwd").val() != password) {
			$("#passwordMsg").html("原密码不正确");
			return false;
		}
		else {
			
			return true;
		}
	});
</script>
</body>
</html>
