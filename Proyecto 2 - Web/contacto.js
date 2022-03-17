const form  = document.getElementsByTagName('form')[0];
const nombre = document.getElementById('nombre');
const email = document.getElementById('mail');
const telefono = document.getElementById('telefono');
const mensaje = document.getElementById('mensaje');
const privacidad = document.getElementById('privacidad');
const adulto = document.getElementById('adulto');

let error = email.nextElementSibling;//??????????
//while ((error = error.nextSibling).nodeType != 1);//?????????


// según la especificación HTML5
const emailRegExp = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;

//combiar por addEventListener?
function addEvent(element, event, callback) {
  let previousEventCallBack = element["on"+event];
  element["on"+event] = function (e) {
    const output = callback(e);
    if (output === false) return false;
    if (typeof previousEventCallBack === 'function') {
      output = previousEventCallBack(e);
      if(output === false) return false;
    }
  }
};

function checkEmail(email){
    const test = email.value.length === 0 || emailRegExp.test(email.value);
    return test;
}

addEvent(window, "load", function () {
  // Aquí probamos si el campo está vacío (recuerda, el campo no es obligatorio)
  // Si no es así, verificamos si su contenido es una dirección de correo electrónico con el formato correcto.
  email.className = checkEmail(email) ? "valid" : "invalid";
});

// Esto define lo que sucede cuando el usuario escribe en el campo
addEvent(email, "input", function () {
  if (checkEmail(email)) {
    email.className = "valid";
    error.innerHTML = "";
    error.className = "error";
  } else {
    email.className = "invalid";
  }
});

// Esto define lo que sucede cuando el usuario intenta enviar los datos.
addEvent(form, "submit", function () {
  if (!checkEmail(email)) {
    email.className = "invalid";
    error.innerHTML = "I expect an e-mail, darling!";
    error.className = "error active";
    // Algunos navegadores antiguos no son compatibles con el método event.preventDefault ()
    return false;
  } else {
    email.className = "valid";
    error.innerHTML = "";
    error.className = "error";
  }
});