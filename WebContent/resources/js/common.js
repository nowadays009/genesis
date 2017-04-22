//nav 메뉴 클릭시 메뉴 css효과 추가
$(function(){
	  $('.nav>li').click(function(){
		$('.nav>li').removeClass('active');  
	    $(this).addClass('active');
	  });
});
//nav 메뉴 마우스오버 마우스아웃 메뉴 css효과 추가
$(function(){
	$('.nav>li').hover(function(){
		 $(this).addClass('active');
	}, function(){
		 $(this).removeClass('active');
	});
});

