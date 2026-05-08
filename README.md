# 🛒 OtakuStore

> Sistema de E-Commerce para productos de anime y cultura otaku desarrollado en Java.


---

# 🎯 Objetivo del Proyecto

Desarrollar una aplicación de comercio electrónico orientada a productos de anime y cultura otaku utilizando Java, aplicando programación orientada a objetos, manejo de interfaces gráficas y conexión con base de datos SQLite.

---

# ✨ Características Principales

✅ Sistema de autenticación (Login)  
✅ Gestión de productos  
✅ Carrito de compras dinámico  
✅ Sistema de pagos  
✅ Generación de factura  
✅ Historial de compras  
✅ Gestión de usuarios y administradores  
✅ Interfaz gráfica en Java Swing  
✅ Persistencia de datos con SQLite  
✅ Código modular y orientado a objetos  

---

# 🛠️ Tecnologías Utilizadas

| Tecnología | Uso |
|---|---|
| Java | Lógica principal |
| Java Swing | Interfaz gráfica |
| SQLite | Base de datos |
| NetBeans | Entorno de desarrollo |
| Git & GitHub | Control de versiones |

---

# 📂 Estructura del Proyecto

```bash
src/
 └── main/
      └── java/
           └── com/
                └── mycompany/
                     ├── ecommerce/      # Ventanas principales
                     ├── molde/         # Modelos de datos
                     ├── database/      # Conexión SQLite
                     └── service/       # Servicios del sistema


# 🚀 Funcionalidades del Sistema

## 🔐 Login

El sistema cuenta con autenticación para usuarios y administradores mediante usuario y contraseña.

### Funciones:

- Inicio de sesión
- Validación de credenciales
- Acceso según el tipo de usuario
- Protección básica de acceso

---

## 🛒 Tienda

La tienda permite visualizar y gestionar productos relacionados con anime y cultura otaku.

### Funciones:

- Mostrar productos disponibles
- Agregar productos al carrito
- Eliminar productos del carrito
- Actualizar cantidades
- Mostrar total acumulado
- Interfaz gráfica dinámica con Java Swing

---

## 💳 Sistema de Pago

El sistema permite realizar compras y generar comprobantes automáticamente.

### Funciones:

- Simulación de pago
- Generación de factura
- Limpieza automática del carrito
- Confirmación visual de compra
- Registro automático de compra realizada

---

## 📜 Historial de Compras

El sistema almacena las compras realizadas por los usuarios mediante la clase:

```java
Historial.java
```

### Información registrada:

- Productos comprados
- Cantidad de productos
- Total pagado
- Método de pago
- Usuario comprador
- Resumen de factura

---

# 🗄️ Base de Datos

El proyecto utiliza SQLite como sistema de base de datos local.

Archivo principal:

```bash
tienda.db
```

### Operaciones implementadas:

- Crear tablas
- Insertar productos
- Consultar productos
- Actualizar información
- Eliminar productos
- Persistencia de datos

---

# 🧠 Programación Orientada a Objetos

Durante el desarrollo se aplicaron conceptos fundamentales de POO.

### Conceptos utilizados:

- Clases y objetos
- Encapsulamiento
- Modularidad
- Separación por capas
- Manejo de eventos
- Reutilización de código
- Métodos y atributos
- Organización por paquetes

---

# ▶️ Ejecución del Proyecto

## 📋 Requisitos

- Java JDK 17 o superior
- NetBeans IDE
- SQLite JDBC

---

## ⚙️ Pasos para ejecutar

### 1. Clonar el repositorio

```bash
git clone https://github.com/Ricardo-Malo/OtakuStore.git
```

---

### 2. Abrir el proyecto

Abrir la carpeta del proyecto utilizando NetBeans IDE.

---

### 3. Ejecutar la aplicación

Ejecutar la clase principal:

```bash
Login.java
```

---

# 📂 Estructura del Proyecto

```bash
src/
 └── main/
      └── java/
           └── com/
                └── mycompany/
                     ├── ecommerce/
                     ├── molde/
                     ├── database/
                     └── service/
```

### Descripción de paquetes

| Paquete | Función |
|---|---|
| ecommerce | Interfaces gráficas y ventanas |
| molde | Modelos y entidades |
| database | Conexión SQLite |
| service | Servicios y lógica del sistema |

---

# 👥 Integrantes

| Nombre | Rol |
|---|---|
| Ricardo Gabriel Malo Cuibas| Desarrollador |
| Jhael Julián Marín Meza | Desarrollador |
| Samuel Hernández Romero | Desarrollador |
| Samuel Rodelo Vargas | Desarrollador |
---

# 📌 Estado del Proyecto

✅ Sistema funcional  
✅ CRUD implementado  
✅ Base de datos integrada  
✅ Historial de compras agregado  
✅ Interfaz gráfica terminada  
✅ Integración con SQLite completada  

---

# 🔗 Repositorio

Repositorio oficial del proyecto:

```bash
https://github.com/Ricardo-Malo/OtakuStore
```
