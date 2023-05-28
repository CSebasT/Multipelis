<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Alquiler</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Alquiler</h1>
    <form action="alquileres?accion=registrar" method="post" class="form-group needs-validation" onsubmit="return validarCedula(); validarCodigo();" name="buscarDatosParaAlquiler" novalidate>
        <div class="mb-3">
            <label for="codigoEjemplar" class="form-label">Código del Ejemplar</label>
            <input type="text" class="form-control" name="codigoEjemplar" id="codigoEjemplar" placeholder="Código" required>
            <div class="valid-feedback">
                Completo
            </div>
            <div class="invalid-feedback">
                Campo Vacio o Erroneo, ingresa nuevamente
            </div>
        </div>
        <div class="mb-3">
            <label for="cedulaCliente" class="form-label">CI del Cliente</label>
            <input type="text" class="form-control" name="cedulaCliente" id="cedulaCliente" placeholder="10 digitos" required>
            <div class="valid-feedback">
                Completo
            </div>
            <div class="invalid-feedback">
                Campo Vacio o Erroneo, ingresa nuevamente
            </div>
        </div>
        <div class="mb-3">
            <label for="numeroDias" class="form-label">Número de días de alquiler</label>
            <input type="number" class="form-control" name="numeroDias" id="numeroDias" placeholder="Días" required>
            <div class="valid-feedback">
                Completo
            </div>
            <div class="invalid-feedback">
                Campo Vacio o Erroneo, ingresa nuevamente
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Alquilar</button>
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

    function validarCodigo(input) {
        const codigoRegex = /^\d{4}$/;
        if (!codigoRegex.test(input.value)) {
            input.setCustomValidity("Ingrese un código válido de 4 dígitos (por ejemplo, 0001)");
        } else {
            input.setCustomValidity("");
        }
    }

    window.addEventListener('DOMContentLoaded', function() {
        const form = document.querySelector('form');
        const codigoInput = document.querySelector('#codigoEjemplar');
        const cedulaInput = document.querySelector('#cedulaCliente');

        cedulaInput.addEventListener('input', function() {
            validarCedula(cedulaInput);
        });

        codigoInput.addEventListener('input', function() {
            validarCodigo(codigoInput);
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js"
        integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js"
        integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ"
        crossorigin="anonymous"></script>

</body>
</html>
