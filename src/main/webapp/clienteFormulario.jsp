<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Multipelis</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<h1>Bienvenido a Multipelis</h1>
<h2>Completa los datos para registrar al cliente</h2>
<div class="container">
    <form action="cliente?accion=registrar" method="post" onsubmit="return validarCedula(); validarTexto(); validarDireccion(); validarEmail(); validarTelefono(); " class="form-group needs-validation" novalidate>
        <div class="mb-3">
            <label for="cedulaCliente" class="form-label">CI</label>
            <input type="text" class="form-control" name="cedulaCliente" id="cedulaCliente" requiered>
            <div class="valid-feedback">
                Completo
            </div>
            <div class="invalid-feedback">
                Campo Vacio o Erroneo, ingresa nuevamente
            </div>
        </div>
        <div class="mb-3">
            <label for="nombreCliente" class="form-label">Nombre</label>
            <input type="text" class="form-control" name="nombreCliente" id="nombreCliente" required>
            <div class="valid-feedback">
                Completo
            </div>
            <div class="invalid-feedback">
                Campo Vacio o Erroneo, ingresa nuevamente
            </div>
        </div>
        <div class="mb-3">
            <label for="apellidoCliente" class="form-label">Apellido</label>
            <input type="text" class="form-control" name="apellidoCliente" id="apellidoCliente" required>
            <div class="valid-feedback">
                Completo
            </div>
            <div class="invalid-feedback">
                Campo Vacio o Erroneo, ingresa nuevamente
            </div>
        </div>
        <div class="mb-3">
            <label for="emailCliente" class="form-label">Email </label>
            <input type="email" class="form-control" name="emailCliente" id="emailCliente" required>
            <div class="valid-feedback">
                Completo
            </div>
            <div class="invalid-feedback">
                Campo Vacio o Erroneo, ingresa nuevamente
            </div>
        </div>
        <div class="mb-3">
            <label for="direccionCliente" class="form-label">Direccion</label>
            <input type="text" class="form-control" name="direccionCliente" id="direccionCliente" required >
            <div class="valid-feedback">
                Completo
            </div>
            <div class="invalid-feedback">
                Campo Vacio o Erroneo, ingresa nuevamente
            </div>
        </div>
        <div class="mb-3">
            <label for="telefonoCliente" class="form-label">Telefono</label>
            <input type="text" class="form-control" name="telefonoCliente" id="telefonoCliente" required>
            <div class="valid-feedback">
                Completo
            </div>
            <div class="invalid-feedback">
                Campo Vacio o Erroneo, ingresa nuevamente
            </div>
        </div>


        <button type="submit" class="btn btn-primary">Guardar</button>
    </form>
</div>
<script>
    function validarCedula(input) {
        const cedulaRegex = /^\d{10}$/;
        if (!cedulaRegex.test(input.value)) {
            input.setCustomValidity("Ingrese una cédula válida (10 dígitos)");
        } else {
            input.setCustomValidity("");
        }
    }

    function validarTexto(input) {
        const textoRegex = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s']+$/;
        if (!textoRegex.test(input.value)) {
            input.setCustomValidity("Ingrese un valor válido (solo letras y espacios)");
        } else {
            input.setCustomValidity("");
        }
    }

    function validarDireccion(input) {
        const direccionRegex = /^[a-zA-Z0-9\s#'-]+$/;
        if (!direccionRegex.test(input.value)) {
            input.setCustomValidity("Ingrese una dirección válida");
        } else {
            input.setCustomValidity("");
        }
    }

    function validarEmail(input) {
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailRegex.test(input.value)) {
            input.setCustomValidity("Ingrese un correo electrónico válido");
        } else {
            input.setCustomValidity("");
        }
    }

    function validarTelefono(input) {
        const telefonoRegex = /^\d{7,10}$/;
        if (!telefonoRegex.test(input.value)) {
            input.setCustomValidity("Ingrese un número de teléfono válido (entre 7 y 10 dígitos)");
        } else {
            input.setCustomValidity("");
        }
    }

    window.addEventListener('DOMContentLoaded', function() {
        const form = document.querySelector('form');
        const cedulaInput = document.querySelector('#cedulaCliente');
        const nombreInput = document.querySelector('#nombreCliente');
        const apellidoInput = document.querySelector('#apellidoCliente');
        const direccionInput = document.querySelector('#direccionCliente');
        const emailInput = document.querySelector('#emailCliente');
        const telefonoInput = document.querySelector('#telefonoCliente');

        cedulaInput.addEventListener('input', function() {
            validarCedula(cedulaInput);
        });

        nombreInput.addEventListener('input', function() {
            validarTexto(nombreInput);
        });

        apellidoInput.addEventListener('input', function() {
            validarTexto(apellidoInput);
        });

        direccionInput.addEventListener('input', function() {
            validarDireccion(direccionInput);
        });

        emailInput.addEventListener('input', function() {
            validarEmail(emailInput);
        });

        telefonoInput.addEventListener('input', function() {
            validarTelefono(telefonoInput);
        });

        form.addEventListener('submit', function(event) {
            if (!form.checkValidity()) {
                event.preventDefault();
                event.stopPropagation();
            }
            form.classList.add('was-validated');
        });
    });
</script>

<script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (() => {
        'use strict'

        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        const forms = document.querySelectorAll('.needs-validation')

        // Loop over them and prevent submission
        Array.from(forms).forEach(form => {
            form.addEventListener('submit', event => {
                if (!form.checkValidity()) {
                    event.preventDefault()
                    event.stopPropagation()
                }

                form.classList.add('was-validated')
            }, false)
        })
    })()
</script>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js" integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js" integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ" crossorigin="anonymous"></script>
<br/>
</body>
</html>