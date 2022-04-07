$(document).ready(function() {
	
   var imageslength = $("#imageslength").val();
  		 $('#myform').on('click', '.delete-image', function(){
			var answer = confirm("Are you want to delete image?");
			imageslength--;
				if(answer==true && imageslength>=1)
				{
						var imageid = +this.id; 
						$.ajax({
						url: "RemoveImage",
						type: "POST",
						data: {
							   imgId : imageid,
							  }, 
						success : function(data){
						$("#"+imageid).remove();
						}
					    });
				 }
				 else
				 {
					alert("One Image is Compulsory!");
				}
      		});
      		
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
			$(".checked-radio").mouseover(function(){
				$(".r-btn-error").remove();
				if($("input[name='Gender']:checked").length == 0)
				{
					$(".checked-radio").after('<span class="r-btn-error">*Required Field</span>');
				}
			})
			$(".checked-checkbox").mouseover(function(){
				$(".btn-error").remove();
				if($("input[name='lang']:checked").length == 0)
				{
					$(".checked-checkbox").after('<span class="btn-error">*Required Field</span>');
				}
			})
			 $('input[type="file"]').change(function(e) {
				 var files = e.target.files;
				 filesLength = files.length ;
           		for (var i = 0; i < filesLength ; i++) 
            	{
					$(".error").remove();
	                var file = e.target.files[i].name;
	                 var extn = file.substring(file.lastIndexOf('.') + 1).toLowerCase();
	                 if (extn == "gif" || extn == "png" || extn == "jpg" || extn == "jpeg")
             		{}
             		else{
						$('input[type="file"]').after('<span class="error">*Please Select only images!</span>');
					}
	                }
			});
			
			$("#city_0").keyup(function(e){
				e.preventDefault();
				$(".error").remove();
				var city = $('#city_0').val();
			    for(let i=0;i < city.length;i++)
			    {
			     var ch = city.charAt(i);
			     if (!(ch>='a'&&ch<='z') && !(ch>='A'&&ch<='Z')) 
			     {
					  $('#city_0').after('<span class="error">*Only Alphabet are Allowed</span>');
					  break;
			     }
			    }
			  });
			  $("#state_0").keyup(function(e){
				e.preventDefault();
				$(".error").remove();
				var state = $('#state_0').val();
			    for(let i=0;i < state.length;i++)
			    {
			     var ch = state.charAt(i);
			     if (!(ch>='a'&&ch<='z') && !(ch>='A'&&ch<='Z')) 
			     {
					  $('#state_0').after('<span class="error">*Only Alphabet are Allowed</span>');
					  break;
			     }
			    }
			  });
			  $("#country_0").keyup(function(e){
				e.preventDefault();
				$(".error").remove();
				var country = $('#country_0').val();
			    for(let i=0;i < country.length;i++)
			    {
			     var ch = country.charAt(i);
			     if (!(ch>='a'&&ch<='z') && !(ch>='A'&&ch<='Z')) 
			     {
					  $('#country_0').after('<span class="error">*Only Alphabet are Allowed</span>');
					  break;
			     }
			    }
			  });
	     $("#pincode_0").keyup(function(){
			$(".error").remove();
							console.log("#pincode_0");
							var pincode = $("#pincode_0").val();
							if(pincode.match("[^0-9]"))
							{
								$('#pincode_0').after('<span class="error">*Only Numbers are allowed</span>');
							}
	    })
	    /*
			var count=0;
			$(".add-btn").click(function(){
					count++;
					//console.log("c "+count);
					for(let i=1;i<=count;i++)
					{
							$("#city_"+i).keyup(function(e){
								e.preventDefault();
								$(".error").remove();
								var city = $('#city_'+i).val();
							    for(let j=0;j < city.length;j++)
							    {
							     var ch = city.charAt(j);
							     if (!(ch>='a'&&ch<='z') && !(ch>='A'&&ch<='Z')) 
							     {
									  $('#city_'+i).after('<span class="error">*Only Alphabet are Allowed</span>');
									  break;
							     }
							    }
							  });
							  $("#state_"+i).keyup(function(e){
								e.preventDefault();
								$(".error").remove();
								var state = $('#state_'+i).val();
							    for(let j=0;j < state.length;j++)
							    {
							     var ch = state.charAt(j);
							     if (!(ch>='a'&&ch<='z') && !(ch>='A'&&ch<='Z')) 
							     {
									  $('#state_'+i).after('<span class="error">*Only Alphabet are Allowed</span>');
									  break;
							     }
							    }
							  });
							  $("#country_"+i).keyup(function(e){
								e.preventDefault();
								$(".error").remove();
								var country = $('#country_'+i).val();
							    for(let j=0;j < country.length;j++)
							    {
							     var ch = country.charAt(j);
							     if (!(ch>='a'&&ch<='z') && !(ch>='A'&&ch<='Z')) 
							     {
									  $('#country_'+i).after('<span class="error">*Only Alphabet are Allowed</span>');
									  break;
							     }
							    }
							  });
						$("#pincode_"+i).keyup(function(e){
							$(".error").remove();
							console.log("#pincode_"+i)
							var pincode = $("#pincode_"+i).val();
							if(pincode.match("[^0-9]"))
							{
								$('#pincode_'+i).after('<span class="error">*Only Numbers are allowed</span>');
							}
						})
					}
				});*/
				/*
			$(".add-btn").click(function()
			{
				var c = count++;
				console.log("count:"+count);
				for(var i=0;i<=count;i++)
			{
				console.log("#pincode_"+i);
				$("#pincode_"+i).keyup(function(){
					$(".error").remove();
					var pincode = $("#pincode_"+i).val();
					console.log(pincode);
				if(pincode.match("[^0-9]"))
				{
					$('#pincode_'+i).after('<span class="error">*Only Numbers are allowed</span>');
				}
				})
			}
			});*/
			
			
			/*
			$(".remove-data").click(function()
			{
				console.log("clicked");
				c--;
				console.log("r count:"+c);
			});*/
});