$(document).ready(function() {
        $("#imgUpload").on('change', function() {
        
        	var image = $("#image");
            image.empty();
            var reader = new FileReader();
                reader.onload = function(e) {
                  $("<img />", {
                    "src": e.target.result,
                    "class": "uploadedimage"
                  }).appendTo(image);
                }
                image.show();
                reader.readAsDataURL($(this)[0].files[0]);
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
      });
      



