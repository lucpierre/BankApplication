// Our JS main file
let nav_links = document.querySelectorAll("nav li");

nav_links.forEach(
    function(link){
        link.onmouseenter = function(){
            link.style.borderLeft = '3px solid #EEB14F';
        }
        
        link.onmouseleave = function(){
            link.style.borderLeft = 'none';
        }
        
    }    
);