Tienda Dispositivos

# Proyecto Angular

--Sigue estos pasos para ejecutarlo en tu máquina local.

Requisitos

 - Node.js version 22 LTS (version estable)
    Link: https://nodejs.org/

 - Angular CLI instalado globalmente:
    npm install -g @angular/cli

# Atencion

En caso de tener error al momento de agregar algun comando de ng
agregar en powerShell lo siguiente

      Set-ExecutionPolicy Unrestricted -Scope CurrentUser

Luego, confirma escribiendo "Y" y presionando Enter.


# Gestor Base de datos POSTGRESQL

Requisitos:

- Instalar PostgreSql version 17.4
  https://www.enterprisedb.com/downloads/postgres-postgresql-downloads
  
- importar la base de datos Tienda TiendaProductosElectronicos

# Proyecto Spring Boot

Requisitos:

- Descargar IDLE SpringToolSuite4 - ECLIPSE:
  https://spring.io/tools

- version jdk: 17.0.12



# Ejecucion de proyectos

Angular

 1. clonar el repositorio con:
        
        git clone https://github.com/EmanuelMora117/TiendaDispositivos.git

 2. Abrir visual studio code y Entrar al proyecto "tiendaDispositivosFrontEnd"

 3. Instalar las dependecias para que el proyecto arranque correctamente:

        npm install
4. Para iniciar la aplicación en modo desarrollo, usar el siguiente comando:

        ng serve -o
   Al momento de terminar de cargar, deberá abrir automaticamente el navegador con la ruta http://localhost:4200/
   en caso de que no haya abierto el navegador, entonces agregar directamente la ruta http://localhost:4200/home
   
SpringBoot

1. Para abrir el proyeto, eclipse le pedira la ruta del proyecto, por favor agregar la siguente ruta:

       ruta/TiendaDispositivos

   Luego de que cargue y abra el eclipse spring boot, dirigirse a las sigueintes opciones
    - Menu izquierdo dirigirse a la opcion "import Proyects"
    - desplegar la opcion Maven
    - Seleccionar la opcion "Existing maven Proyects"
    - Dar clik en la opcion "browse"
    - Seleccionar el proyecto "tiendaDispositivosBackEnd"
    - Dar click en finish
2. presionar las teclas Alt + F5 el cual se abrira una ventana para seleccionar el proyecto con el proposito de que se instalen las dependecias correctamente.
3. Dirigirse al archivo "application.properties" realizar lo siguiente:
    - configurar el puerto el cual dice server.port el cual ya trae el 8088, lo puede cambiar pero se recomienda mantenerlo con ese puerto
    - configurar la conexion a la base de datos POSTGRESQL
       spring.datasource.url=jdbc:postgresql://localhost:5432/TiendaProductosElectronicos -> ese es el puerto por defecto cuando se descarga postgreSQL
       spring.datasource.username=postgres -> usario por defecto cuando se descarga postgresql a menos de que se haya cambiado
       spring.datasource.password= ingresar aqui la contraseña del super usuario que configuro en la instalacion del POSTGRESQL
      
 4. Para correr el proyecto se debe lo siguiente
      - dirigir a la opcion ![image](https://github.com/user-attachments/assets/c8f0f7ce-8134-4612-a919-121810901d37), darle clic a la flecha que esta en la parte derecha que indica que se despliega 
      - seleccionar la opcion "Run Configurations" ![image](https://github.com/user-attachments/assets/904a2aac-cf05-45a2-80b8-7da6efd2b270)
      - dirigirse a la opcion "Spring Boot App" ![image](https://github.com/user-attachments/assets/baadd658-62fa-4672-b318-79240c4463df)
      - en proyect agregar la opcion que sale, y luego dar click en search y la primera opcion que sale, darle doble click
      - Luego darle click en Apply y luego run
      - El servidor correra en el puerto 8088 o en el puerto que se haya cambiado, pero es mejor no cambiarlo

INICIO DE SESION
   1. Puede iniciar sesion con las siguientes credenciales:
      Usuario: ADMSUP
      Contraseña: 12345678
