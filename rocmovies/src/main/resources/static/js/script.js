var style = document.getElementById("movie-style");
style.addEventListener("change", function(){
    console.log(style.value);

    href = "http://localhost:9090/rocmovies/movie?style=" + style.value;

    if(style.value != null){
        window.location = href
    }
});

// var customer = document.getElementById("borrow-customer");
// customer.addEventListener("change", function(){
//     console.log(customer.value);
//
//     href = "http://localhost:9090/rocmovies/borrow?customer=" + customer.value;
//     console.log(href)
//
//     if(customer.value != null){
//         window.location = href
//     }
// });