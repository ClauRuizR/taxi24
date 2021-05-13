# Taxi24

Esta aplicacion esta construida en spring boot 2.3.10.RELEASE.

#Para correr la app
./mvnw spring-boot:run

La base de datos que se esta utilizando es una base de datos en memoria, conocida como h2. Escogi esta base de datos por el hecho que me permite hacer todo el desarrollo del aplicativo funcionando sin la necesidad de preocuparme por instalar una base de datos, cambiar credenciales para conectarse, etc.

Para poder acceder a la base de datos h2 se utiliza el siguiente URL http://localhost:8080/h2-console

Utilizando el JDBC Url: jdbc:h2:mem:testdb con la contraseña: password y el usuario es: sa

Este aplicativo tiene swagger configurado para ver todos los servicios creados y poder ejecutarlos desde la misma herramienta, URL: http://localhost:8080/swagger-ui.html





