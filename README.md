# Rick and Morty Characters Viewer

Este proyecto es una aplicación Java que muestra los personajes de "Rick and Morty" utilizando la API pública. La interfaz gráfica está construida con Swing y permite navegar entre las páginas de personajes, mostrando detalles e imágenes de cada uno.

## Características

- Mostrar una tabla con los personajes de "Rick and Morty".
- Navegación entre páginas: primera, anterior, siguiente y última.
- Deshabilitar botones de navegación cuando no hay más páginas disponibles.
- Mostrar imágenes y detalles de cada personaje.

## Requisitos

- Java JDK 8 o superior.
- Conexión a internet para consumir la API de "Rick and Morty".

## Instalación

1. Clona este repositorio:

   ```bash
   git clone https://github.com/tu-usuario/rick-and-morty-viewer.git
   ```

2. Ingresa al directorio del proyecto:

   ```bash
   cd rick-and-morty-viewer
   ```

3. Compila el proyecto:

   ```bash
   javac -d bin src/com/maximo/*.java
   ```

   Asegúrate de que los paquetes y dependencias están correctamente configurados.

## Ejecución

1. Ejecuta la aplicación:

   ```bash
   java -cp bin com.maximo.RickAndMortyFrame
   ```

   Se abrirá la interfaz gráfica mostrando los personajes.

## Uso

- Al iniciar, se cargará la primera página de personajes.
- Utiliza los botones de navegación para moverte entre las páginas:
  - **Primera Página**: Ir a la primera página.
  - **Anterior**: Ir a la página anterior.
  - **Siguiente**: Ir a la página siguiente.
  - **Última Página**: Ir a la última página.
- Los botones se deshabilitan automáticamente si no hay más páginas disponibles en esa dirección.

## Estructura del Proyecto

- `src/com/maximo/`: Código fuente del proyecto.
  - `RickAndMortyFrame.java`: Interfaz gráfica y lógica de navegación.
  - `RickAndMortyService.java`: Servicio para consumir la API.
  - `CharacterTableModel.java`: Modelo para la tabla de personajes.
  - `CharacterResponse.java`: Clases para mapear la respuesta de la API.
- `bin/`: Directorio de salida para los archivos compilados.

## Dependencias

- Biblioteca estándar de Java (Swing, IO, Net).
- API pública de Rick and Morty:
  - Documentación: [rickandmortyapi.com](https://rickandmortyapi.com/)

## Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue o pull request para proponer mejoras.

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.
