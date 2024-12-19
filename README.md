# Biblioteca REST API

## Descripción

La **Biblioteca REST API** es una aplicación desarrollada en Java que permite gestionar un sistema de libros. Ofrece endpoints para realizar operaciones CRUD sobre los libros, incluyendo:
- Crear un nuevo libro.
- Consultar los detalles de un libro por su ID.
- Listar todos los libros disponibles.
- Actualizar la información de un libro existente.
- Eliminar un libro.

Esta API está diseñada para garantizar la integridad de los datos y proporcionar respuestas claras en caso de errores.

---

## Características

- **Endpoints RESTful**: Estructura clara y estandarizada para las operaciones CRUD.
- **Swagger OpenAPI**: Documentación interactiva para explorar y probar los endpoints.
- **Manejo de excepciones**: Respuestas HTTP adecuadas para errores comunes, como recurso no encontrado.
- **Inmutabilidad de datos**: Los objetos de tipo `Book` se mantienen inmutables para garantizar la consistencia.
- **Uso de DTOs**: Separa los datos transferidos entre las capas de negocio y de presentación.

---

## Tecnologías utilizadas

- **Java 22**: Lenguaje de programación principal.
- **Spring Boot 3**: Framework para la creación de aplicaciones REST.
- **Swagger/OpenAPI**: Documentación interactiva de la API.
- **Lombok**: Reducción del código boilerplate.
- **JUnit 5** y **Mockito**: Pruebas unitarias y simulaciones.

---

## Estructura del proyecto

```
src/
|-- main/
|   |-- java/
|       |-- com.talentofuturo.biblioteca/
|           |-- controller/          # Controladores REST
|           |-- service/             # Lógica de negocio
|           |-- repository/          # Persistencia en memoria
|           |-- dto/                 # Objetos de transferencia de datos
|           |-- exceptions/          # Manejo de excepciones personalizadas
|-- test/                             # Pruebas unitarias
```

---

## Endpoints principales

### **Crear un nuevo libro**
- **POST** `/api/v1/books`
- **Cuerpo de la petición:**
```json
{
  "title": "El Principito",
  "description": "Un clásico de la literatura infantil",
  "year": 1943,
  "author": "Antoine de Saint-Exupéry"
}
```
- **Respuesta:**
    - `201 Created`: Retorna el ID del libro creado.

---

### **Obtener un libro por ID**
- **GET** `/api/v1/books/{id}`
- **Respuesta:**
    - `200 OK`: Retorna los detalles del libro.
    - `404 Not Found`: Si el libro no existe.

---

### **Listar todos los libros**
- **GET** `/api/v1/books`
- **Respuesta:**
    - `200 OK`: Retorna una lista de todos los libros disponibles.

---

### **Actualizar un libro**
- **PUT** `/api/v1/books/{id}`
- **Cuerpo de la petición:**
```json
{
  "title": "Nuevo título",
  "description": "Nueva descripción",
  "year": 2023,
  "author": "Nuevo autor"
}
```
- **Respuesta:**
    - `200 OK`: Si el libro fue actualizado exitosamente.
    - `404 Not Found`: Si el libro no existe.

---

### **Eliminar un libro**
- **DELETE** `/api/v1/books/{id}`
- **Respuesta:**
    - `200 OK`: Si el libro fue eliminado exitosamente.
    - `404 Not Found`: Si el libro no existe.

---

## Instalación y configuración

### **Prerrequisitos**

- Tener instalado **Java 22** o superior.
- Tener configurado **Maven** o **Gradle** para la gestión de dependencias.

### **Instrucciones**

1. Clona este repositorio:
   ```bash
   git clone https://github.com/JulioRom/Java-Library.git
   ```

2. Navega al directorio del proyecto:
   ```bash
   cd biblioteca-rest-api
   ```

3. Ejecuta la aplicación:
   ```bash
   ./mvnw spring-boot:run
   ```
   o, si usas Gradle:
   ```bash
   ./gradlew bootRun
   ```

4. Accede a la documentación de la API:
    - URL: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## Pruebas

### **Ejecutar pruebas**
Para ejecutar las pruebas unitarias, utiliza:

```bash
./mvnw test
```
o
```bash
./gradlew test
```

### **Cobertura de pruebas**
La API está cubierta con pruebas unitarias que verifican:
- El comportamiento de los controladores REST.
- La lógica de negocio en los servicios.
- El manejo de errores comunes.

---

## Futuras mejoras

- Integración con una base de datos real (por ejemplo, MySQL o PostgreSQL).
- Autenticación y autorización con JWT.
- Integración continua y despliegue automatizado.

---

## Contribuciones

Las contribuciones son bienvenidas. Para colaborar:
1. Realiza un fork de este repositorio.
2. Crea una rama para tu funcionalidad o corrección: `git checkout -b feature/nueva-funcionalidad`.
3. Envía un pull request.

---

## Autor
- **Julio Rom**
- [JulioRom](https://github.com/JulioRom)

---

## Licencia
Este proyecto está licenciado bajo la licencia MIT. Consulta el archivo `LICENSE` para obtener más información.

