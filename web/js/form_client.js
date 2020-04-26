let select_user_type = document.querySelector("#user_type_input");
let professional_part_form = document.querySelector("#professional-part-form");

select_user_type.onchange = function(){
        professional_part_form.classList.toggle("d-none");
}