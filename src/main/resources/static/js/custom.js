var owl = $('.owl-carousel');
owl.owlCarousel({
    items:4,
    loop:true,
    margin:10,
    autoplay:true,
    autoplayTimeout:1000,
    autoplayHoverPause:true
});
$('.play').on('click',function(){
    owl.trigger('play.owl.autoplay',[1000])
})
$('.stop').on('click',function(){
    owl.trigger('stop.owl.autoplay')
});


$(function(){
    $('#walletForm').on('submit', function(e){
        e.preventDefault();
        $.post('http://localhost:8080/home/wallet/checkout/process',
            $('#walletForm').serialize(),
            function(data, status, xhr){
                // do something here with response;
            });
    });
});

