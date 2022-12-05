/*
    Document   : script.js
    Created on : Jun 10, 2021, 11:58:31 AM
    Author     : Hoang Van Tue
*/

function changeImage(url) {
//    console.log(document.querySelector(".photo-album .slideshow > img").src);
    document.querySelector(".photo-album .slideshow > img").src = url;
}
document.addEventListener("DOMContentLoaded", function () {
    var images = document.querySelectorAll(".photo-album .thumbnail>a img");
    var currentIndex = 0;
    var runThread;

    function nextImage() {
        if (currentIndex == images.length - 1) {
            currentIndex = 0;
        }
        currentIndex++;
        document.querySelector(".photo-album .slideshow > img#show-img").src = images[currentIndex].src;
    }
    function startSlideShow() {
        if (typeof runThread === 'undefined')
            runThread = setInterval(function () {
                nextImage()
            }, 1000);
    }
    function stopSlideShow() {
        clearInterval(runThread);
        runThread = undefined;
    }
    document.querySelector("#btn-play").addEventListener("click", function () {
        startSlideShow();
        
        document.querySelector("#btn-play").style.display = "none";
        document.querySelector("#btn-pause").style.display = "block";
    });
    document.querySelector("#btn-pause").addEventListener("click", function () {
        stopSlideShow();
        document.querySelector("#btn-pause").style.display = "none";
        document.querySelector("#btn-play").style.display = "block";
    });

});

