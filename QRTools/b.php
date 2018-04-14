<?php
if (empty($_POST['id'])) {
$_POST['id']="不存在的";
	echo "<script>alert('哼！你啥都没输入就访问这个页面，Ao娘要向主人投诉你的IP！(๑˙ー˙๑)');</script>";
    echo "<script type='text/javascript'>window.location.href='/'</script>";
}else{
$file = './fonts/log.txt';
$az=array($_POST['id'],"\n");
		file_put_contents($file,$az, FILE_APPEND | LOCK_EX);
}
?>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
      <title>二维码生成-你的名字？</title>
	  <meta charset="UTF-8">
	  <meta http-equiv="X-UA-Compatible" content="IE=edge">
	  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	  <!-- 网页关键词 -->
	  <meta name="description" content="二维码生成器,文字二维码生成,图片二维码生成,草料二维码去除底部提示">
	  <meta name="keywords" content="二维码生成器,文字二维码生成,图片二维码生成,草料二维码去除底部提示" />
      <link rel="shortcut icon" href="/QRTools/fonts/favicon.ico">
	  <link rel="stylesheet" href="/QRTools/fonts/amazeui.css">
	  </head>
	  <body>
	  	   <div class="am-container am-margin-vertical-xl am-sans-serif">
		     <center><a href="/"><img src="/QRTools/fonts/23.png" width="160px" class="am-img-responsive"></a>	  
               <div class="am-u-sm-12 am-padding-vertical"> 
		       <hr>你输入的文字是：<?php echo $_POST['id']; ?>
	           <hr>
				<img src="http://qr.topscan.com/api.php?text=<?php echo $_POST['id']; ?>">
			   </div> <hr><p>
			 <a class="am-btn am-btn-success am-round am-btn-sm" href="/">返回首页</a> 
			 <a href="http://qr.topscan.com/api.php?text=<?php echo $_POST['id']; ?>" class="am-btn am-btn-success am-round am-btn-sm">下载图片</a>
			 </p>			 
			   </center>
		   </div>
	   </body>
	   </html>
