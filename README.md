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

POSTGRESQL
 1. Para importar la BD primero se debe descargar el .SQL
 2. dirigirse a postgreSQL y crear un BD con el nombre "TiendaProductosElectronicos" o si prefiere puede agregar otro nombre, pero se recomienda crearlo con este mismo nombre
 3. Luego de crear la base de datos, debe dar click derecho y dirigirse a la opcion "Restore..." ![image](https://github.com/user-attachments/assets/2e6051d5-2192-41c6-bd2b-df91cf1d7395)
 4. Se abrira una ventana donde tendra algunas opciones, se dirigira a la opcion que dice "FILENAME" y en la parte derecha en el icono de carpeta, dar click, luego se debe dirigir a la parte que indica el tipo de archivo a importar y debe asegurar de que esta seleccionado en tipo "SQL FILE" ![image](https://github.com/user-attachments/assets/28a7c459-0d5d-4b1a-b71e-e0a4f99cf0ea) ![image](https://github.com/user-attachments/assets/641955c1-8536-44f3-a78a-87548a057d87)
 5. Dar click en abrir y luego "Restore"
 6. por ultimo vera en la siguiente ruta las tablas cargadas correctamente ![image](https://github.com/user-attachments/assets/646e85a6-d39d-4328-8d1b-551b21d1181e)
   
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
       spring.datasource.url=jdbc:postgresql://localhost:5432/TiendaProductosElectronicos -> donde dice "TiendaProductosElectronicos" tiene que ir el nombre de la base de datos que anterior mente creo, si agrego el mismo que esta en esta configuracion puede continuar, sino entonces cambielo por el que definio
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
