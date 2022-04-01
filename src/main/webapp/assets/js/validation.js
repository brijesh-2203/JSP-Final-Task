$(document).ready(function() {
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
						 var pwd = $('#pwd').val();
						 var repwd = $('#repwd').val();
					  if(repwd != pwd)
					  {
						 $('#repwd').after('<span class="error">*Password should be same</span>');
					  }
				});
				
			  $("input[name='image[]']").change(function(e){
				$(".error").remove();
				var img = $("input[name='image[]']").val();
				var point = img.lastIndexOf(".");
        		var extention =(img.substring(point + 1)).toLowerCase();
        		 if((extention == "jpg") || (extention == "jpeg") || (extention == "png")){}
        			else
        			{
						$("input[name='image[]']").after('<span class="error">*Please Select only images!</span>');
					}
			});
			
			$("#email").keyup(function(e){
					$(".error").remove();
					var mail = $("#email").val();
					var message = $("#message").val();
					console.log(message);
					var mailFormat="^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
	        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	        
					if(!mail.match(mailFormat)){
						$('#email').after('<span class="error">*Please enter valid Email</span>');
					}
					else if(mail==message)
					{
						$('#email').after('<span class="error">*Email Exist</span>');
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
			let count=0;
			$(".add-btn").click(function(e){
				count++;
				console.log("ca"+count);
			});
			console.log(count);
			$(".remove-data").click(function(e){
				console.log("clicked");
				count--;
				console.log("crin"+count);
			})
			console.log("cr"+count);
			$(".pincode").keyup(function(e){
				$(".error").remove();
				var pincode = $(".pincode").val();
				if(pincode.match("[^0-9]"))
				{
					$('.pincode').after('<span class="error">*Only Numbers are allowed</span>');
				}
				else if(pincode.length<6 ||pincode.length>6)
				{
					
				}
			})
});