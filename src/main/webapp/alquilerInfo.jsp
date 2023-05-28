<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Datos del Alquiler</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Datos del alquiler</h1>
    <br>
    <h2>Alquiler</h2>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Nro</th>
            <th scope="col">Cantidad de días</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <c:set var="a1" value="${requestScope['alquiler']}"/>
            <th scope="row">${a1.numero}</th>
            <th scope="row">${a1.dias}</th>
        </tr>
        </tbody>
    </table>
    <br>
    <h2>Pelicula</h2>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Título</th>
            <th scope="col">Duración</th>
            <th scope="col">Año</th>
            <th scope="col">Sinopsis</th>
            <th scope="col">Genero</th>
            <th scope="col">Puntaje</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <c:set var="p1" value="${requestScope['pelicula']}"/>
            <th scope="row">${p1.titulo}</th>
            <th scope="row">${p1.duracion}</th>
            <th scope="row">${p1.añoLanzamiento}</th>
            <th scope="row">${p1.sinopsis}</th>
            <th scope="row">${p1.genero.nombre}</th>
            <th scope="row">${p1.puntaje.puntajeTotal}</th>
        </tr>
        </tbody>
    </table>
    <br>
    <h2>Cliente</h2>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Nombre</th>
            <th scope="col">Apellido</th>
            <th scope="col">Correo</th>
            <th scope="col">Dirección</th>
            <th scope="col">Teléfono</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <c:set var="c1" value="${requestScope['cliente']}"/>
            <th scope="row">${c1.nombre}</th>
            <th scope="row">${c1.apellido}</th>
            <th scope="row">${c1.correo}</th>
            <th scope="row">${c1.direccion}</th>
            <th scope="row">${c1.telefono}</th>
        </tr>
        </tbody>
    </table>
    <a href="index.jsp" type="button" class="btn btn-primary">Ok</a>
</div>

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