# SPRINGBOOT
 # Spring Boot Test Demo

Este es un proyecto de demostración de Spring Boot que implementa un servicio básico para gestionar empleados. Utiliza una base de datos MariaDB para almacenar la información de los empleados.
- Implementación de **Spring Security**
- Configuración de llaves públicas y privadas con OpenSSL
- Login y Registro con **Json Web Token**
- Autorizar el acceso a un endpoint a usuarios logueados
- Configuración de **CORS** para que el Front-end pueda acceder a tu proyecto
## Descripción

El proyecto proporciona una API RESTful para gestionar empleados, permitiendo realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar). La aplicación está configurada para conectarse a una base de datos MariaDB.

## Requisitos
- Intellij
- Java 17 o superior
- Maven
- MariaDB
- Spring Boot 2.7.3 o superior
- Spring Data JPA
- Spring Web
- Lombok
- H2 Database
- MariaDB Driver
- Spring Boot DevTools
- Spring Boot Actuator
- Spring Boot Test
## Configuración

Antes de ejecutar la aplicación, asegúrate de tener MariaDB instalado y en funcionamiento. Crea una base de datos llamada `unit_test_db` y configura el usuario y la contraseña según sea necesario.

### Configuración de la base de datos

Asegúrate de que el archivo `application.properties` contenga la siguiente configuración:

```properties
spring.application.name=springboot-test-demo
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mariadb://localhost:3306/unit_test_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=#De123456789.
spring.jpa.database-platform=org.hibernate.dialect.MariadbDialect
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MariaDBDialect
spring.jpa.open-in-view=false
Estructura de la base de datos
Ejecuta el siguiente script SQL para crear la tabla employees en tu base de datos:

sql
Run
Copy code
CREATE TABLE employees
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    email      VARCHAR(255) NOT NULL,
    CONSTRAINT pk_employees PRIMARY KEY (id)
);
Dependencias
Asegúrate de que tu archivo pom.xml contenga las siguientes dependencias:

xml
Run
Copy code
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>
<dependency>
    <groupId>org.mariadb.jdbc</groupId>
    <artifactId>mariadb-java-client</artifactId>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
Uso
Para ejecutar la aplicación, utiliza el siguiente comando en la raíz del proyecto:

bash
Run
Copy code
mvn spring-boot:run
Una vez que la aplicación esté en funcionamiento, podrás acceder a los siguientes endpoints de la API:

Endpoints
Crear un empleado

POST /api/employees
Cuerpo de la solicitud:
json
Run
Copy code
{
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com"
}
Obtener todos los empleados

GET /api/employees
Obtener un empleado por ID

GET /api/employees/{id}
Actualizar un empleado

PUT /api/employees/{id}
Cuerpo de la solicitud:
json
Run
Copy code
{
    "firstName": "Jane",
    "lastName": "Doe",
    "email": "jane.doe@example.com"
}
Eliminar un empleado

DELETE /api/employees/{id}
Implementación
Clases Principales
Modelo Employee: Representa la entidad de empleado en la base de datos.
Interfaz EmployeeService: Define las operaciones CRUD para gestionar empleados.
Clase EmployeeServiceImpl: Implementa la lógica de negocio para el servicio de empleados.
Interfaz EmployeeRepository: Extiende JpaRepository para proporcionar acceso a los datos de empleados.
Controlador EmployeeController: Maneja las solicitudes HTTP y coordina las respuestas.
