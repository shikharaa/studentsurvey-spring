const toggle = document.querySelector('.hamburger');
const sec = document.querySelector('.sec');

sec.onclick = function(){
    document.querySelector("body").classList.add('active');
}

toggle.onclick = function(){
    document.querySelector("body").classList.toggle('active');
}
