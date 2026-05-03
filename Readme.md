# Sistema de Gestión de Pedidos

Aplicación desarrollada en Java con Spring Boot para la gestión básica de pedidos en un entorno tipo e-commerce. Permite registrar clientes, procesar pedidos, aplicar descuentos y gestionar pagos.

## 🚀 Tecnologías

* Java 17
* Spring Boot
* Spring Data JPA
* H2 Database
* Maven
* JUnit

## 📦 Funcionalidades

* Creación y gestión de pedidos
* Asociación de productos a pedidos
* Cálculo de totales
* Aplicación de descuentos por tipo de cliente
* Uso de cupones de descuento
* Procesamiento de pagos
* Validación básica de datos

## 🧱 Estructura del proyecto

El proyecto sigue una arquitectura por capas:

* **controller**: manejo de solicitudes HTTP
* **service**: lógica de negocio
* **repository**: acceso a datos
* **model**: entidades del sistema

## ▶️ Ejecución

Para ejecutar el proyecto:

```bash
mvn spring-boot:run
```

La aplicación iniciará en:

```text
http://localhost:8080
```

## 🧪 Pruebas

Para ejecutar las pruebas unitarias:

```bash
mvn test
```

## 🗄️ Base de datos

Se utiliza una base de datos en memoria H2 para facilitar el desarrollo y pruebas.

Consola disponible en:

```text
http://localhost:8080/h2-console
```

## 📌 Notas

Este proyecto está diseñado como una base funcional para la gestión de pedidos, permitiendo su extensión con nuevas funcionalidades como integración con pasarelas de pago, autenticación de usuarios o persistencia en bases de datos externas.
