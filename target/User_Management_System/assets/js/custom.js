$(document).ready(function() {
	$('.input-images').imageUploader({
   imagesInputName: 'image',
});
/*
  $('#fileupload').fileupload({
    dataType:'mediumblob',
    done:function (e, data) {
    }
});*/
/*
	$("#files").on("change",function(e) {
		 var imgPath = $(this)[0].value;
          var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
            var files = e.target.files ,
            filesLength = files.length ;
             if (extn == "gif" || extn == "png" || extn == "jpg" || extn == "jpeg")
             {
            	for (var i = 0; i < filesLength ; i++) 
            	{
	                var f = files[i]
	                var fileReader = new FileReader();
	                fileReader.onload = (function(e) {
	                var file = e.target;
			           $("<div class='image'><img class='uploadedimage' src='" + e.target.result + "' title='" + file.name + "'/>" +
			            "<br><a class='btn remove btn-danger'>Remove</a>" +
			            "</div>").insertAfter("#files");
			          $(".remove").click(function(){
			           	 $(this).parent(".image").remove();
			          });
               });
               fileReader.readAsDataURL(f);
               }
           }
           else {
            alert("Please Select only images!");
          }
      });*/
      /*
	    let c=0;
	   
		$(".add-photos-btn").click(function(){
			c++;
		});
		console.log(c);
      $("#image_"+c).on("change",function(e) {
		 var imgPath = $(this)[0].value;
          var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
            var files = e.target.files ,
            filesLength = files.length ;
             if (extn == "gif" || extn == "png" || extn == "jpg" || extn == "jpeg")
             {
            	for (var i = 0; i < filesLength ; i++) 
            	{
	                var f = files[i]
	                var fileReader = new FileReader();
	                fileReader.onload = (function(e) {
	                var file = e.target;
			           $("<div class='image'><img class='uploadedimage' src='" + e.target.result + "' title='" + file.name + "'/>" +
			            "<br>" +
			            "</div>").insertAfter("#image_"+c);
               });
               fileReader.readAsDataURL(f);
               }
           }
           else {
            alert("Please Select only images!");
          }
      });*/
      /*
      	    let c=0;
	   
		$(".add-photos-btn").click(function(){
			c++;
			
			console.log(c);
		});
		 var data = $("#image_"+c);
         $("#image_0").on('change', function() {
	console.log("hello "+data);
	var countFiles = $(this)[0].files.length;
         var imgPath = $(this)[0].value;
          var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
            if (extn == "gif" || extn == "png" || extn == "jpg" || extn == "jpeg")
             {
				for (var i = 0; i < countFiles; i++) 
              {
          		  var reader = new FileReader();
                reader.onload = function(e) {
					var file = e.target;
                  $("<div class='image'><img class='uploadedimage' src='" + e.target.result + "' title='" + file.name + "'/>" +
			            "<br>" +
			            "</div>").insertAfter("#image_"+c);
                }
                reader.readAsDataURL($(this)[0].files[i]);
                }
              }
              else {
            alert("Please Select only images!");
          }
        });*/
   /*
	
	    let c=0;
	   
		$(".add-photos-btn").click(function(){
			c++;
			console.log(data);
		});
		 var data = $("#image_"+c);
        data.on('change', function() {
	var countFiles = $(this)[0].files.length;
         var imgPath = $(this)[0].value;
          var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
      
		var image = $("#desc_"+c);
		console.log(c);
        	//var image = $(".image");
          //  image.empty();
            if (extn == "gif" || extn == "png" || extn == "jpg" || extn == "jpeg")
             {
				for (var i = 0; i < countFiles; i++) 
              {
					
					 console.log(image);
          		  var reader = new FileReader();
                reader.onload = function(e) {
                  $("<img />", {
                    "src": e.target.result,
                    "class": "uploadedimage"
                  }).appendTo(image);
                }
                image.show();
                reader.readAsDataURL($(this)[0].files[i]);
                }
              }
              else {
            alert("Please Select only images!");
          }
        });
     */
        $('#add-more').cloneData({
		  mainContainerId:'main-container',
		
		  cloneContainer:'container-item',
		
		  removeButtonClass:'remove-item',
		  
		  maxLimit: 0,
		
			minLimit: 1,
		
		 	removeConfirm:true,
		
		  removeConfirmMessage:'Are you sure want to delete?'
		
		});
		
		let count=0;
		$("#add-btn").click(function(){
			count++;
		});
		$("#remove-btn").hide();
		if(count>0)
		{
			$("#remove-btn").show();
		}
		
		    
			$(".del-image").click(function(e){
				console.log("clicked");
				$(img).removeAttr('src');
			})
		
      });
      



