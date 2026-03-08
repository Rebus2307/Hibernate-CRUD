# CRUD Nativo con Java y Hibernate ORM ☕🐘

Este repositorio contiene una aplicación Java que implementa un CRUD (Crear, Leer, Actualizar, Eliminar) completo utilizando el framework ORM Hibernate de forma nativa. 

El proyecto fue desarrollado como parte de las prácticas de la unidad de aprendizaje de Desarrollo de Frameworks Web Cliente y Backend, aplicando el patrón de diseño DAO (Data Access Object) y la gestión manual de transacciones.

## 🚀 Características Principales

* **Mapeo Objeto-Relacional (ORM):** Uso de anotaciones JPA (`@Entity`, `@Table`, `@Id`, `@Column`) en la clase `Producto`.
* **Configuración XML:** Conexión a la base de datos gestionada a través de `hibernate.cfg.xml`.
* **Patrón DAO:** Separación de la lógica de acceso a datos utilizando una interfaz y su respectiva implementación.
* **Gestión de Transacciones:** Control manual del ciclo de vida de la sesión (`Session`) y las transacciones (`beginTransaction`, `commit`, `rollback`).

## 🛠️ Requisitos Previos

Para ejecutar este proyecto en tu entorno local, necesitarás:

* **Java Development Kit (JDK):** Versión 17 o superior (el proyecto fue probado con JDK 25).
* **Maven:** Para la gestión de dependencias (`pom.xml`).
* **Base de Datos:** MySQL (o PostgreSQL adaptando el driver).
* **IDE:** IntelliJ IDEA, Eclipse o tu editor de preferencia.

## ⚙️ Configuración e Instalación

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/Rebus2307/Hibernate-CRUD.git
   ```

2. **Preparar la Base de Datos:**
Abre tu gestor de MySQL y ejecuta el siguiente script para crear la base de datos:
```sql
CREATE DATABASE si_db_hibernate;

```


*Nota: No es necesario crear la tabla manualmente. Hibernate está configurado con `hbm2ddl.auto = update`, por lo que generará la tabla `productos` automáticamente al ejecutar el programa.*
3. **Configurar Credenciales:**
Ve al archivo `src/main/resources/hibernate.cfg.xml` y actualiza las propiedades con tu usuario y contraseña de MySQL:
```xml
<property name="hibernate.connection.username">TU_USUARIO</property>
<property name="hibernate.connection.password">TU_CONTRASEÑA</property>

```



## ▶️ Ejecución y Resultados

Para probar la aplicación, ejecuta la clase `Main.java`. Esta clase instanciará el DAO y realizará una prueba automatizada insertando productos, leyéndolos, actualizando un registro y eliminando otro.

Al ejecutar el programa, Hibernate mostrará en la consola sus bitácoras de inicialización (mensajes `INFO` y `WARN`) y el código SQL generado en tiempo real para cada operación del CRUD.

A continuación, se muestra una captura de la ejecución exitosa finalizando con `Process finished with exit code 0`:

<img width="1259" height="920" alt="imagen" src="https://github.com/user-attachments/assets/a8a9a38b-5fa1-4111-9486-1bd169c44ae3" />


---

*Desarrollado por Wilfrido Cruz Merlin - Escuela Superior de Cómputo (ESCOM).*
