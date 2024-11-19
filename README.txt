# Piloto JSF Spring 2

Este proyecto es una aplicación web para gestionar una lista de partidos entre equipos. Permite visualizar información de los partidos, agregar nuevos y editar los existentes. Además, puedes gestionar los equipos, visualizar su lista y modificar su información.

## Tecnologías utilizadas

- **Java**: Lenguaje de programación principal para el desarrollo de la lógica de negocio y la interacción con la base de datos.
- **Spring**: Framework utilizado para la configuración y gestión de los beans, facilitando la integración con otras tecnologías y la gestión de la lógica de negocio.
- **JSF (JavaServer Faces)**: Framework para la creación de interfaces de usuario basadas en componentes, que facilita la interacción entre la vista y la lógica de negocio.
- **Hibernate**: Framework de mapeo objeto-relacional que permite interactuar con la base de datos de manera eficiente, gestionando la persistencia de datos y simplificando las consultas.

## Características

- **Visualización de partidos**: Muestra resultados, fechas, comentarios y otros datos importantes de cada partido.
- **Edición de partidos**: Puedes añadir nuevos partidos y editar los existentes.
- **Gestión de equipos**: Los equipos son seleccionables y puedes ver su lista completa.
- **Interfaz web con JSF**: Utiliza tecnologías como JSF y Spring para la capa de presentación y lógica de negocio.
- **Base de datos HSQLDB**: La aplicación utiliza una base de datos embebida HSQLDB.

## Requisitos

- **Librerías necesarias**: Asegúrate de descargar las librerías necesarias desde el repositorio o usa las equivalentes.
- **Base de datos**: La aplicación usa HSQLDB como base de datos embebida. Antes de ejecutar la aplicación, asegúrate de haber levantado el servidor de HSQLDB:
  - Descarga el archivo `hsqldb-2.3.zip` disponible en el repositorio.
  - Ejecuta `runServer` desde el directorio `hsqldb-2.3` para iniciar el servidor de base de datos.

## Instrucciones de ejecución

1. **Asegúrate de tener el servidor de base de datos HSQLDB corriendo:**
   - Descarga y descomprime el archivo `hsqldb-2.3.zip`.
   - Ejecuta el script `runServer` para iniciar el servidor de base de datos.
   
2. **Configura las librerías necesarias**: Asegúrate de descargar las librerías desde el repositorio o usar las versiones equivalentes.

3. **Ejecuta la aplicación web** a través de tu servidor preferido (por ejemplo, Tomcat).

## Notas adicionales

- El archivo `applicationContext.xml` configura los beans necesarios para la integración con Spring.
- Los archivos `.xhtml` contienen las vistas de la aplicación, mientras que `faces-config.xml` gestiona la configuración de JSF.

