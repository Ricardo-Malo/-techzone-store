# OtakuStore 🛒🎌

Sistema de comercio electrónico desarrollado en Java aplicando Programación Orientada a Objetos (POO).  
El proyecto permite gestionar productos, realizar compras y generar pedidos mediante una interfaz gráfica hecha con Swing y persistencia de datos con SQLite.

---

# 📌 Características

- Inicio de sesión
- Gestión de productos
  - Agregar productos
  - Editar productos
  - Eliminar productos
- Carrito de compras
- Cálculo automático del total
- Generación de pedidos/factura
- Persistencia de datos usando SQLite
- Interfaz gráfica en Java Swing
- Aplicación de conceptos POO:
  - Herencia
  - Encapsulación
  - Polimorfismo
  - Abstracción
  - Manejo de excepciones
  - Colecciones (`ArrayList`)

---

# 🛠️ Tecnologías utilizadas

- Java
- Java Swing
- SQLite
- Maven
- NetBeans IDE

---

# 📂 Estructura del proyecto

```bash
src/
│
├── com.mycompany.database
│   └── Conexion.java
│
├── com.mycompany.ecommerce
│   ├── Login.java
│   └── VentanaTienda.java
│
├── com.mycompany.molde
│   ├── Productos.java
│   ├── Carrito.java
│   ├── Pedido.java
│   ├── Usuario.java
│   ├── Cliente.java
│   ├── Admin.java
│   ├── Pago.java
│   └── PagoTarjeta.java
│
└── com.mycompany.service
    └── ProductoService.java
