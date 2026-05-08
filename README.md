# 🛒 OtakuStore

> Sistema de E-Commerce para productos de anime y cultura otaku desarrollado en Java.

---

# 🎯 Objetivo del Proyecto

Desarrollar una aplicación de comercio electrónico orientada a productos de anime y cultura otaku utilizando Java, aplicando Programación Orientada a Objetos (POO), manejo de interfaces gráficas y conexión con base de datos SQLite.

---

# ✨ Características Principales

✅ Sistema de autenticación (Login)  
✅ Gestión de productos (CRUD)  
✅ Carrito de compras dinámico  
✅ Sistema de pago simulado  
✅ Generación de factura  
✅ Historial de compras temporal  
✅ Gestión de usuarios y administradores  
✅ Interfaz gráfica desarrollada en Java Swing  
✅ Persistencia de productos con SQLite  
✅ Arquitectura modular por paquetes  

---

# 🛠️ Tecnologías Utilizadas

| Tecnología | Uso |
|---|---|
| Java | Lógica principal |
| Java Swing | Interfaz gráfica |
| SQLite | Base de datos |
| JDBC | Conexión a SQLite |
| Maven | Gestión del proyecto |
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
                     ├── ecommerce/   # Interfaces gráficas
                     ├── molde/       # Modelos y entidades
                     ├── database/    # Conexión SQLite
                     └── service/     # Servicios del sistema
```

---

# 🚀 Funcionalidades del Sistema

## 🔐 Login

El sistema cuenta con autenticación para usuarios y administradores mediante usuario y contraseña.

### Funciones

- Inicio de sesión
- Validación de credenciales
- Acceso según el rol
- Protección básica de acceso

---

## 🛒 Tienda

La tienda permite visualizar y gestionar productos relacionados con anime y cultura otaku.

### Funciones

- Mostrar productos disponibles
- Agregar productos al carrito
- Calcular total del carrito
- Mostrar productos dinámicamente
- Actualizar catálogo
- Interfaz gráfica dinámica con Java Swing

---

## 💳 Sistema de Pago

El sistema permite realizar compras y generar comprobantes automáticamente.

### Funciones

- Simulación de pago
- Generación de factura
- Confirmación visual de compra
- Limpieza automática del carrito
- Registro de compra realizada

---

## 📜 Historial de Compras

El sistema almacena temporalmente las compras realizadas durante la ejecución del programa mediante la clase:

```java
Historial.java
```

### Información registrada

- Productos comprados
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

### Operaciones implementadas

- Crear tablas
- Insertar productos
- Consultar productos
- Actualizar información
- Eliminar productos
- Persistencia de datos de productos

---

# 🧠 Programación Orientada a Objetos

Durante el desarrollo se aplicaron conceptos fundamentales de POO.

### Conceptos utilizados

- Clases y objetos
- Herencia
- Polimorfismo
- Encapsulamiento
- Clases abstractas
- Modularización
- Manejo de eventos
- Reutilización de código
- Colecciones Java
- Manejo de excepciones
- Organización por paquetes

---

# ▶️ Ejecución del Proyecto

## 📋 Requisitos

- Java JDK 17 o superior
- Apache NetBeans
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

```java
main(String[] args)
```

Clase:

```bash
Login.java
```

---

# 📦 Descripción de Paquetes

| Paquete | Función |
|---|---|
| ecommerce | Interfaces gráficas y ventanas |
| molde | Modelos y entidades |
| database | Gestión SQLite |
| service | Servicios y lógica del sistema |

---

# 👥 Integrantes

| Nombre | Rol |
|---|---|
| Ricardo Gabriel Malo Cuibas | Desarrollador |
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

# 🧩 Diagramas UML y Casos de Uso

---

# 📌 Diagrama de Casos de Uso

El sistema **OtakuStore** permite la interacción entre dos actores principales:

- 👤 Cliente
- 🛠️ Administrador

---

## 👤 Cliente

El cliente puede realizar las siguientes acciones:

- Iniciar sesión
- Ver catálogo de productos
- Agregar productos al carrito
- Calcular total del carrito
- Realizar pagos
- Generar factura

---

## 🛠️ Administrador

El administrador tiene permisos para:

- Agregar productos
- Editar productos
- Eliminar productos
- Gestionar el catálogo
- Gestionar productos en SQLite

---

# 🔄 Relaciones de Casos de Uso

| Caso de Uso | Relación |
|---|---|
| Agregar al carrito → Calcular total | include |
| Realizar pago → Generar factura | include |
| Pago con tarjeta → Realizar pago | extend |
| CRUD de productos → Persistencia SQLite | include |

---

# 🧠 Diagrama UML del Proyecto

El sistema se encuentra organizado utilizando Programación Orientada a Objetos y arquitectura modular por paquetes.

---

# 📦 Paquetes del Sistema

```text
com.mycompany.database
com.mycompany.service
com.mycompany.ecommerce
com.mycompany.molde
```

---

# 🗄️ Paquete: database

## Clase Conexion

Encargada de gestionar la conexión con SQLite.

### Métodos principales

```java
conectar()
crearTabla()
insertarProducto()
eliminarProducto()
actualizarPrecio()
```

---

# ⚙️ Paquete: service

## Clase ProductoService

Gestiona operaciones relacionadas con productos.

### Funciones

- Obtener productos
- Comunicación con SQLite
- Consultar productos registrados

---

# 👥 Paquete: molde

Contiene las entidades principales del sistema.

---

## 👤 Usuario

Clase base para usuarios del sistema.

### Atributos

```java
nombre
rol
```

### Métodos

```java
getRol()
```

---

## 👤 Cliente

Hereda de Usuario.

### Rol

```java
CLIENTE
```

---

## 🛠️ Admin

Hereda de Usuario.

### Rol

```java
ADMIN
```

---

## 💳 Pago (Abstracta)

Clase abstracta base para métodos de pago.

### Método abstracto

```java
pagar(double monto)
```

---

## 💳 PagoTarjeta

Hereda de Pago.

### Función

Procesar pagos con tarjeta de forma simulada mediante sobrescritura del método:

```java
pagar(double monto)
```

---

## 📦 Productos

Representa productos de la tienda.

### Atributos principales

```java
nombre
precio
```

---

## 🛒 Carrito

Gestiona productos seleccionados por el usuario.

### Atributos

```java
ArrayList<Productos>
```

### Funciones

```java
agregar()
total()
mostrar()
```

---

# 🖥️ Paquete: ecommerce

Contiene la interfaz gráfica del sistema.

---

## 🔐 Login

Gestiona autenticación de usuarios.

### Funciones

```java
main(String[] args)
```

---

## 🛍️ VentanaTienda

Ventana principal del sistema.

### Funciones

```java
iniciar()
reconnectListeners()
```

### Relaciones

- Usa ProductoService
- Usa Carrito
- Usa Historial
- Usa Conexion

---

## 📜 Historial

Gestiona el historial temporal de compras.

### Funciones

```java
registrarCompra()
```

---

# 🔗 Relaciones UML

| Relación | Clases |
|---|---|
| Herencia | Usuario → Cliente/Admin |
| Herencia | Pago → PagoTarjeta |
| Asociación | VentanaTienda → Carrito |
| Asociación | ProductoService → Conexion |
| Asociación | VentanaTienda → Historial |
| Contención | Carrito → Productos |

---

# 🧠 Conceptos de POO Aplicados

✅ Herencia  
✅ Polimorfismo  
✅ Encapsulamiento  
✅ Modularización  
✅ Asociación entre clases  
✅ Clases abstractas  
✅ Manejo de eventos  
✅ Manejo de excepciones  
✅ Persistencia con SQLite  
✅ Arquitectura modular  

---

# 🔗 Repositorio

Repositorio oficial del proyecto:

```bash
https://github.com/Ricardo-Malo/OtakuStore
```
