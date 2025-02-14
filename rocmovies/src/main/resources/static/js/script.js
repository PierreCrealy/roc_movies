var select = document.getElementById("movie-style");
select.addEventListener("change", function(){
    console.log(select.value);

    href = "http://localhost:9090/rocmovies/movie?style=" + select.value;

    if(select.value != null){
        window.location = href
    }
});