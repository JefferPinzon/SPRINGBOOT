📌 Tabla de Contenidos
📋 Descripción

🚀 Tecnologías

🔧 Configuración

🌐 Endpoints

🔒 Seguridad

🧪 Pruebas

🚀 Ejecución



📋 Descripción
Aplicación de gestión de productos desarrollada con Spring Boot 3, utilizando:
✔ Spring WebFlux (Reactivo)
✔ Spring Security (Autenticación básica)
✔ MongoDB Reactivo (Base de datos NoSQL)
✔ Internacionalización (i18n) en español, inglés y francés

🚀 Tecnologías
Tecnología	Versión	Uso
Java	17	Lenguaje principal
Spring Boot	3.1.0	Framework base
Spring WebFlux	-	Manejo reactivo de endpoints
Spring Security	-	Autenticación básica
Spring Data Reactive MongoDB	-	Conexión reactiva con MongoDB
Lombok	-	Reducción de código boilerplate
Gradle	8.5+	Gestión de dependencias
🔧 Configuración
🔹 Requisitos
Java 17 JDK

Gradle 8.5+

MongoDB 6.0+ (Ejecutándose en localhost:27017)

🔹 Dependencias (build.gradle)

groovy
Copy
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-webflux'
    implementation 'org.springframework.boot:spring-boot-starter-security'
    implementation 'org.springframework.boot:spring-boot-starter-data-mongodb-reactive'
    compileOnly 'org.projectlombok:lombok'
    annotationProcessor 'org.projectlombok:lombok'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testImplementation 'io.projectreactor:reactor-test'
}
🔹 Configuración MongoDB (application.yml)

yaml
Copy
spring:
  data:
    mongodb:
      uri: mongodb://localhost:27017/productosdb
  security:
    user:
      name: usuario
      password: clave123
      
🌐 Endpoints

🔹 Productos (🔒 Requiere autenticación)
Método	Endpoint	Descripción
GET	/api/productos	Listar todos los productos
POST	/api/productos	Crear un nuevo producto
GET	/api/productos/{id}	Obtener producto por ID
PUT	/api/productos/{id}	Actualizar producto
DELETE	/api/productos/{id}	Eliminar producto

🔹 Internacionalización (i18n)

http
Copy
GET /api/productos/mensaje?lang={es|en|fr}
🔒 Seguridad
Autenticación HTTP Basic

Credenciales por defecto:

Usuario: usuario

Contraseña: clave123

🧪 Pruebas

🔹 Ejecutar pruebas

bash
Copy
# Todas las pruebas
./gradlew test

# Solo pruebas unitarias
./gradlew test --tests "*UnitTest*"

# Solo pruebas de integración
./gradlew test --tests "*IntegrationTest*"

🔹 Reporte de cobertura (Jacoco)
bash
Copy
./gradlew jacocoTestReport

🚀 Ejecución

🔹 Iniciar la aplicación

bash
Copy
./gradlew bootRun

🔹 Construir el proyecto

bash
Copy
./gradlew build

🔹 Docker (Opcional)

dockerfile
Copy
FROM eclipse-temurin:17-jdk-jammy
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
