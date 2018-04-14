<?php
if(file_exists("./fonts/log.txt")){
		$content = file_get_contents("./fonts/log.txt");
        $content = htmlentities($content);
        $array = explode("\n", $content);
     }else{
        $array="1";
      }
		//使用次数
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
      <link rel="stylesheet" type="text/css" href="/QRTools/static/upload.css">
      <script type="text/javascript" src="/QRTools/static/event.js"></script>
	  </head>
	  <body>
	  	   <div class="am-container am-margin-vertical-xl am-sans-serif">
		     <center><a href="/"><img src="/QRTools/fonts/23.png" width="160px" class="am-img-responsive"></a></center>
               <div class="am-u-sm-12 am-padding-vertical">
		       <hr>
<center>
<form action="a.php" method="post" enctype="multipart/form-data">
                  <div class="am-form-group am-form-file">
                  <button type="button" class="am-btn am-btn-danger am-btn-sm"><i class="am-icon-cloud-upload"></i> 选择要上传的图片</button>
                  <input id="doc-form-file" type="file" name="file"  capture="camera" multiple>
                  <div id="file-list"></div>
                  </div>
               <button type="submit" name="submit" class="itemCopy am-btn am-btn-success am-round am-btn-sm">生成二维码</button>
                </form><hr>
<!--
<!--  enctype="multipart/form-data"
<form id="form" action="c.php" method="post" >
                  <div class="am-form-group am-form-file">
                  <button type="button" class="am-btn am-btn-danger am-btn-sm"><i class="am-icon-cloud-upload"></i> 选择要上传的图片</button>
                  <input id="file_upload" type="file" name="file" accept=*/*," capture="camera" multiple="multiple">
                  <img id="preview" src="img/5b0d798eb4e10266.jpg" style="display: block;margin: 0 auto;max-width: 60%;margin-top: 0.8rem;"></img>
                  <textarea name="img" id="result" rows="30" cols="300" style="display:none;"></textarea>
                   <img id="preview" style="display: block;margin: 0 auto;max-width: 60%;margin-top: 0.8rem;"></img>
              <div id="file-list"></div>
                  </div>
               <button type="submit" name="submit" class="itemCopy am-btn am-btn-success am-round am-btn-sm">生成二维码</button>
</form><hr>
-->
<form action="b.php" method="post" name="form">
<div class="am-u-md-12 am-u-sm-centered">
				<div class="am-form-group am-form-success">
			       <input type="text" name="id" class="am-form-field am-text-center am-round" placeholder="输入需要生成二维码的文字" required/>
				</div>
				<button type="submit" class="am-btn am-btn-success am-round am-btn-sm">生成二维码</button>
</div>
		  </form>	<hr>

本系统累积已被使用“<?php echo (count($array)-1); ?>”次！(●—●)
                </center>
</div></div></br>
	     <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
         <script src="https://cdnjs.cloudflare.com/ajax/libs/amazeui/2.7.2/js/amazeui.min.js"></script>
<script>
		  $(function() {
			$('#doc-form-file').on('change', function() {
			  var fileNames = '';
			  $.each(this.files, function() {
				fileNames += '<span class="am-badge">' + this.name + '</span> ';
			  });
			  $('#file-list').html(fileNames);
			});
		  });

    //           /**
    //  * 从 file 域获取 本地图片 url
    //  *
    //  */
    // function getFileUrl(sourceId) {
    //     var url;
    //     console.log(navigator.userAgent);
    //     if (navigator.userAgent.indexOf("MSIE") >= 1) { // IE
    //         url = document.getElementById(sourceId).value;
    //     } else if (navigator.userAgent.indexOf("Firefox") > 0) { // Firefox
    //         url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));
    //     } else if (navigator.userAgent.indexOf("Chrome") > 0) { // Chrome
    //         url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));
    //     }
    //     return url;
    // }

    // $(function() {
    //     form.reset(); //清除浏览器记录的上次记录
    //     var file;
    //     $(form).on("change", "#file_upload", function() {

    //         // alert("call back")
    //         var $file = $(this);
    //         var fileObj = $file[0];
    //         var windowURL = window.URL || window.webkitURL;
    //         var dataURL;
    //         var $img = $("#preview");

    //         //这里我们判断下类型如果不是图片就返回 去掉就可以上传任意文件
    //         if(!/image\/\w+/.test(fileObj.files[0].type)){
    //             alert("请确保文件为图像类型");
    //             return false;
    //         }

    //         if (fileObj && fileObj.files && fileObj.files[0]) {
    //             console.log("..........."+fileObj.files[0]);
    //             dataURL = windowURL.createObjectURL(fileObj.files[0]);
    //             // dataURL = getFileUrl('file_upload');;
    //             console.log(" upload:"+dataURL+"    file:"+fileObj.files[0]);
    //             $img.attr('src', dataURL);

    //         } else {
    //             console.log("else  upload");
    //             dataURL = $file.val();


    //             // 微软的兼容性设置
    //             var imgObj = document.getElementById("preview");
    //             // 两个坑:
    //             // 1、在设置filter属性时，元素必须已经存在在DOM树中，动态创建的Node，也需要在设置属性前加入到DOM中，先设置属性在加入，无效；
    //             // 2、src属性需要像下面的方式添加，上面的两种方式添加，无效；
    //             imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
    //             imgObj.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = dataURL;

    //         }
    //         //输出选中结果
    //         console.log(this.value);
    //         // alert(this.value);
    //         console.log("dataURL:", dataURL.toString());
    //         //每次选中都保存旧元素，并使用新的控件替换
    //         $(this).clone().replaceAll(file = this);
    //         // 显示图片名称
    //         var fileNames = '';
    //         $.each(this.files, function() {
    //             fileNames += '<span class="am-badge">' + this.name + '</span> ';
    //         });
    //         $('#file-list').html(fileNames);
    //         // 提取图片Base64内容到text-area
    //         var reader = new FileReader();
    //         reader.onload = function () {
    //             var result = this.result;    //data:base64
    //             console.log("result::"+result);
    //             $("#result").text(result);
    //         };
    //         reader.readAsDataURL(fileObj.files[0]);
    //         //$("#result").innerHTML = $('#preview').attr("src");
    //         //console.log($('#preview').attr("src"));

    //     }).submit(function() {
    //         //提交时把之前保存的旧元素替换回去
    //         $("#file_upload").replaceWith(file);
    //     });

    //     /**
    //     * dataURL to blob, ref to https://gist.github.com/fupslot/5015897
    //     * @param dataURI
    //     * @returns {Blob}
    //     */
    //     function dataURItoBlob(dataURI) {
    //         var byteString = atob(dataURI.split(',')[1]);
    //         var mimeString = dataURI.split(',')[0].split(':')[1].split(';')[0];
    //         var ab = new ArrayBuffer(byteString.length);
    //         var ia = new Uint8Array(ab);
    //         for (var i = 0; i < byteString.length; i++) {
    //             ia[i] = byteString.charCodeAt(i);
    //         }
    //         return new Blob([ab], {type: mimeString});
    //     }


    // });
</script>
</body>
</html>
