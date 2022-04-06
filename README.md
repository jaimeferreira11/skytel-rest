<p align="center">
  <h3 align="center">Skytel RestAPI</h3>
  <p align="center">
    Desafío técnico
</p>
  
</p>
<details open="open">
  <summary>Contenido</summary>
  <ol>
    <li>
      <a href="#sobre-el-proyecto">Sobre el proyecto</a>
      <ul>
        <li><a href="#construído-con">Construído con</a></li>
      </ul>
    </li>
    <li>
      <a href="#primeros-pasos">Primeros pasos</a>
      <ul>
        <li><a href="#pre-requisitos">Pre requisitos</a></li>
        <li><a href="#instalación">Instalación</a></li>
      </ul>
    </li>
    <li><a href="#uso">Uso</a></li>
    <li><a href="#documentación">Documentación de las APIs</a></li>
    <li><a href="#contacto">Contacto</a></li>
  </ol>
</details>

## Sobre el proyecto

El proyecto forma parte del desafío técnico de Skytel.

Debes desarrollar un endpoint que reciba la información de tu formulario.
Debes validar los datos recibidos.
Tu endpoint debe devolver un mensaje de error cuando el mail recibido sea igual a
`"john@smith.com"`
Cuando todos los datos sean correctos tu endpoint debe devolver un token generado utilizando
la siguiente regla:

- vocales del nombre + primer letra apellido + última letra apellido + números pares del
  teléfono

Debes simular que el registro se almacena en la base de datos.

### Construído con

- Java
- [Spring Boot](https://spring.io/guides/gs/spring-boot/)
- [Maven](https://maven.apache.org/)

## Primeros pasos

### Pre requisitos

- Java 8 o superior
- Maven 3.x

### Instalación

1. Clonar el repositorio
   ```sh
   git clone https://github.com/jaimeferreira11/skytel-rest.git
   ```
2. Construir
   ```
     mvn clean install -DskipTests
   ```

## Uso

Ejecutar localmente

```
java -jar target/*.jar
```

Context root: `http://localhost:8080`

Project web: [https://github.com/jaimeferreira11/skytel-web.git](https://github.com/jaimeferreira11/skytel-web.git)

## Documentación

Swagger: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Contacto

Lic. Jaime Ferreira - jaimeferreira11@gmail.com
