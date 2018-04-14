<?php
$sa=$_SERVER['HTTP_HOST'];
//获取当前域名
?>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<meta charset="UTF-8">
	<title></title>
	<meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no"/>
	<meta name="robots" content="nofollow,noindex,noarchive"/>
		<style type="text/css">
		.spinner {
		  margin: 100px auto;
		  width: 90px;
		  height: 90px;
		  position: relative;
		  text-align: center;

		  -webkit-animation: rotate 2.0s infinite linear;
		  animation: rotate 2.0s infinite linear;
		}

		.dot1, .dot2 {
		  width: 60%;
		  height: 60%;
		  display: inline-block;
		  position: absolute;
		  top: 0;
		  background-color: #67CF22;
		  border-radius: 100%;

		  -webkit-animation: bounce 2.0s infinite ease-in-out;
		  animation: bounce 2.0s infinite ease-in-out;
		}

		.dot2 {
		  top: auto;
		  bottom: 0px;
		  -webkit-animation-delay: -1.0s;
		  animation-delay: -1.0s;
		}

		@-webkit-keyframes rotate { 100% { -webkit-transform: rotate(360deg) }}
		@keyframes rotate { 100% { transform: rotate(360deg); -webkit-transform: rotate(360deg) }}

		@-webkit-keyframes bounce {
		  0%, 100% { -webkit-transform: scale(0.0) }
		  50% { -webkit-transform: scale(1.0) }
		}

		@keyframes bounce {
		  0%, 100% {
		    transform: scale(0.0);
		    -webkit-transform: scale(0.0);
		  } 50% {
		    transform: scale(1.0);
		    -webkit-transform: scale(1.0);
		  }
		}
	</style>

</head>
<body>
	<!-- <div style="width:100%;text-align:center;position:fixed;top:45%">正在跳转...</div> -->
	<div class="spinner">
	  <div class="dot1"></div>
	  <div class="dot2"></div>
	</div>
</body>

</html>
<script>
	var jump_url="http://<?php echo $sa; ?>/QRTools/index2.php?id=<?php echo $_GET["id"]; ?>";
	window.location.href=jump_url;
	// setTimeout(function(){
	// 	window.location.href=jump_url;
	// }, 500 );
</script>