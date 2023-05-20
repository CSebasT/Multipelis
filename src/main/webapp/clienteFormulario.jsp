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
    <form action="cliente?accion=registrar" method="post" class="form-group">
        <div class="mb-3">
            <label for="cedulaCliente" class="form-label">CI</label>
            <input type="number" class="form-control" name="cedulaCliente" id="cedulaCliente" placeholder="10 digitos">
        </div>
        <div class="mb-3">
            <label for="nombreCliente" class="form-label">Nombre</label>
            <input type="text" class="form-control" name="nombreCliente" id="nombreCliente">
        </div>
        <div class="mb-3">
            <label for="apellidoCliente" class="form-label">Apellido</label>
            <input type="text" class="form-control" name="apellidoCliente" id="apellidoCliente">
        </div>
        <div class="mb-3">
            <label for="emailCliente" class="form-label">Email </label>
            <input type="email" class="form-control" name="emailCliente" id="emailCliente" >
        </div>
        <div class="mb-3">
            <label for="direccionCliente" class="form-label">Direccion</label>
            <input type="text" class="form-control" name="direccionCliente" id="direccionCliente" >
        </div>
        <div class="mb-3">
            <label for="telefonoCliente" class="form-label">Telefono</label>
            <input type="number" class="form-control" name="telefonoCliente" id="telefonoCliente" aria-describedby="telefonoHelp">
            <div id="telefonoHelp" class="form-text">No compartimos tu info con terceros</div>
        </div>
        <button type="submit" class="btn btn-primary">Guardar</button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js" integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js" integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ" crossorigin="anonymous"></script>
<br/>
</body>
</html>