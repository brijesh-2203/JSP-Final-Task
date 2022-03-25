$(document).ready(function() {
        $("#imgUpload").on('change', function() {
         var imgPath = $(this)[0].value;
          var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
        	var image = $("#image");
            image.empty();
            if (extn == "gif" || extn == "png" || extn == "jpg" || extn == "jpeg")
             {
          		  var reader = new FileReader();
                reader.onload = function(e) {
                  $("<img />", {
                    "src": e.target.result,
                    "class": "uploadedimage"
                  }).appendTo(image);
                }
                image.show();
                reader.readAsDataURL($(this)[0].files[0]);
              }
              else {
            alert("Please Select only images!");
          }
        });

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
		
		/* 
		$("#submit-btn").click(function(e){
			e.preventDefault();
		   	 
		    var lname = $('#lastname').val();
		    var pwd = $('#pwd').val();
		    var repwd = $('#repwd').val();
		    */
		    //$(".error").remove();
		    $("#firstname").keyup(function(e){
			
				e.preventDefault();
				$(".error").remove();
				var fname = $('#firstname').val();
			    for(let i=0;i < fname.length;i++)
			    {
			     var ch = fname.charAt(i);
			     if (!(ch>='a'&&ch<='z') && !(ch>='A'&&ch<='Z')) 
			     {
					  $('#firstname').after('<span class="error">*Only Alphabet are Allowed</span>');
					  break;
			     }
			    }
			  });
			    
			  $("#lastname").keyup(function(e){
						e.preventDefault();
						$(".error").remove();
						 var lname = $('#lastname').val();
					  for(let i=0;i < lname.length;i++){
					     var ch = lname.charAt(i);
					     if (!(ch>='a'&&ch<='z') && !(ch>='A'&&ch<='Z')) 
					     {
							  $('#lastname').after('<span class="error">*Only Alphabet are Allowed</span>');
							  break;
					     }
					    }
			    });
			  
			  
			  $("#pwd").keyup(function(e){
						$(".error").remove();
						 var pwd = $('#pwd').val();
					  var regex = "^(?=.*[0-9])"
		            + "(?=.*[a-z])(?=.*[A-Z])"
		            + "(?=.*[@#$%^&+=])"
		            + "(?=\\S+$).{8,20}$";
					  if(pwd.length<5 || pwd.length>14)
					  {
						   $('#pwd').after('<span class="error">*Password must be 5 to 14 character</span>');
					  }
					  else if(!pwd.match(regex))
					  {
						$('#pwd').after('<span class="error">*Password must be strong</span>');
						
					  }
			  });
			   $("#repwd").keyup(function(e){
						$(".error").remove();
						 var repwd = $('#repwd').val();
					  if(pwd != repwd)
					  {
						 $('#repwd').after('<span class="error">*Password should be same</span>');
					  }
				});
				
			  $("#imgUpload").change(function(e){
				$(".error").remove();
				var img = $("#imgUpload").val();
				var point = img.lastIndexOf(".");
        		var extention =(img.substring(point + 1)).toLowerCase();
        		 if(!(extention == "jpg") || (extention == "jpeg") || (extention == "png")){
						$('#imgUpload').after('<span class="error">*Please Select only images!</span>');
        			}
			});
			
			$("#email").keyup(function(e){
					$(".error").remove();
					var mail = $("#email").val();
					var mailFormat="^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
	        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	        
					if(!mail.match(mailFormat)){
						$('#email').after('<span class="error">*Please enter valid Email</span>');
					}
			});
			$("#phone").keyup(function(e){
					$(".error").remove();
					var phone = $("#phone").val();
				if(phone.match("[^0-9]"))
				{
					$('#phone').after('<span class="error">*Only Numbers are allowed</span>');
				}
			});
		
      });
      



