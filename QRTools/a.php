<?php
$sa=$_SERVER['HTTP_HOST'];
//获取当前域名
if (empty($_FILES["file"]["name"])) {
    $_FILES["file"]["name"]="不存在的";
   $_FILES["file"]["type"]="不存在的";
$_FILES["file"]["size"]="不存在的";
$_FILES["file"]["tmp_name"]="不存在的";
	echo "<script>alert('你啥都没输入就访问这个页面？(๑˙ー˙๑)');</script>";
    echo "<script type='text/javascript'>window.location.href='/'</script>";
	}//空表单禁止访问本页面
else{
		//数组-关于日志格式
		$file = './fonts/log.txt';
$az=array($_FILES["file"]["name"],"\n");
		file_put_contents($file,$az, FILE_APPEND | LOCK_EX);
if ((($_FILES["file"]["type"] == "image/gif")
|| ($_FILES["file"]["type"] == "image/jpeg")
|| ($_FILES["file"]["type"] == "image/pjpeg")
|| ($_FILES["file"]["type"] == "image/png"))
&& ($_FILES["file"]["size"] < 2000000))
  {
		// 大小限制20m
  if ($_FILES["file"]["error"] > 0)
    {
    echo "Return Code: " . $_FILES["file"]["error"] . "<br />";
    }
  else
    {
    if (file_exists("./img/" . $_FILES["file"]["name"]))
      {
      }
    else
      {
      move_uploaded_file($_FILES["file"]["tmp_name"],
      "./img/" . $_FILES["file"]["name"]);

      }
    }
  }
else
  {
  	echo "<script>alert('上传失败，请重新上传！(๑˙ー˙๑)');</script>";
    echo "<script type='text/javascript'>window.location.href='/'</script>";
  }
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
		       <hr>
				<?php echo "文件名: " . $_FILES["file"]["name"] . "<br />";
				echo "图片格式: " . $_FILES["file"]["type"] . "<br />";
				echo "图片大小: " . ($_FILES["file"]["size"] / 1024) . " Kb<br />";
				echo "临时文件名: " . $_FILES["file"]["tmp_name"] . "<br />";
				echo "文件存放目录: " . "./img/" . $_FILES["file"]["name"]; ?>
	           <hr>
				<img src="http://pan.baidu.com/share/qrcode?w=450&h=450&url=http://<?php echo $sa; ?>/index3.php?id=<?php echo $_FILES["file"]["name"]; ?>" class="am-img-responsive" alt="二维码"></center>
			   </div>
   </div>
<hr><p>
<center>
			 <a class="am-btn am-btn-success am-round am-btn-sm" href="/">返回首页</a>
			 <a href="http://pan.baidu.com/share/qrcode?w=450&h=450&url=http://<?php echo $sa; ?>/index3.php?id=<?php echo $_FILES["file"]["name"]; ?>" class="am-btn am-btn-success am-round am-btn-sm">下载图片</a>
	</center> </p>
	   </body>
	   </html>
