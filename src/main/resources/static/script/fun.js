function prompt_fun(a){
	              $(a).after("<div id='Layer1'></div>"); 
				  if($('body').height()>$(window).height()){
				      $('#Layer1').height($('body').height());
				  }else{
					  $('#Layer1').height($(window).height());
					  }
				  $('#Layer1').width($('body').width());
				  $(a).css({left:($('body').width()-$(a).width())/2,top:$(window).scrollTop()+($(window).height()-$(a).height())/2});
				  $('#Layer1').fadeTo("fast",0.6); 
				  $(a).show();
				  //$(a).fadeIn("slow"); 
				  $('#Layer1').click(function(){
					  close_prompt_fun(a);
					  })
				jQuery(".caseScroll2").slide({mainCell:"ul",autoPage:true,effect:"left",autoPlay:true});
	}


function close_prompt_fun(a){
	              //$(a).fadeOut("fast"); 
				  $(a).hide();
				  $('#Layer1').fadeOut("slow",function(){
					  $('#Layer1').remove();
					  }); 
	}
	

