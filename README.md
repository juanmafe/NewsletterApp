# Newsletter App

La aplicación se compone de:
- Arquitectura de microservicios.
- Arquitectura hexagonal a nivel de negocio.
- Utiliza Java 11.
- Tecnologías utilizadas: Maven, Spring Boot, Spring Core, Mockito, Junit5, SpringRunner, Jacoco, Jpa y Spring Data.

A continuación se especifican:
- Un pequeño UML donde se describe el diseño del cual se compone la arquitectura (herencia, implementaciones, llamadas), sin entrar a nivel de atributos debido a que la aplicación de diseño es bastante tosca para realizar dicho UML a un buen nivel de detalle. La razón de haber elegido una arquitectura hexagonal ha sido pensando en su escalabilidad. Si el día de mañana se quiere pasar a/ añadir Mongo, se podría a través de un adaptador.
![UML image](/aktios/files/uml.png)

- Un pequeño MER, donde se provee un diagrama entidad-relación de la BBDD utilizada. Para la aplicación se ha usado MariaDB bajo Docker. La razón de haber elegido una BBDD relacional ha sido pensando, de nuevo, en su escalabilidad (posiblidad de crear subcategorias, newsletter para empresas, etc). Las BBDD no relacionales son muy buenas para lectura pero son muy ineficientes para escritura y borrado. Si la aplicación fuese con un propósito más puro de consumo (como un feed), quizás hubiese elegido MongoDB diseñando los documentos en funcion de la vista.
![UML image](/aktios/files/mer.png)

- Los test unitarios y la cobertura de los mismos con Junit5, Mockito y SpringRunner. Estos se ejecutan al iniciar la aplicación. Se han testeado únicamente las clases que contienen negocio (las que se componen de entidades y DTOs las he excluido con una anotación creada manualmente para jacoco). La cobertura es del 100% aunque en la captura no lo muestre. Por alguna razón, jacoco no está detectando los test de los métodos void de los delete, aunque como se muestra en la segunda captura, si que ese están ejecutando (parece ser un bug del mismo).
![UML image](/aktios/files/jacoco.png)
![UML image](/aktios/files/voids.png)


- La aplicación dispone de tres llamadas:

    * GET: /newsletter/subscriptions
       * Response (200):
         > [
             {
                 "name": "Juan Manuel",
                 "surname": "Fernández",
                 "birthday": "2021-06-14",
                 "frequency": "Weekly",
                 "technologies": [
                     "Javascript",
                     "Java",
                     ".NET"
                 ]
             },
             {
                 "name": "Marta",
                 "surname": "Díaz",
                 "birthday": "2021-06-14",
                 "frequency": "Monthly",
                 "technologies": [
                     ".NET",
                     "Angular",
                     "MySQL",
                     "Mongo"
                 ]
             }
           ]
    * POST: /newsletter/subscriptions
       * BodyRequest:
         > {
           "name" : "Prueba",
           "surname" : "Insert",
           "frequency" : {"id" : "1"},
           "technologies" : [{"id" : "1"}, {"id" : "2"}]
           }
       * Response (201):
         > 13
    * DELETE: /newsletter/subscriptions/10
        * Response (200).

- La instalación puede realizarse de dos modos:
    * Importando el proyecto desde un IDE con soporte de Spring Boot e iniciandola con un click.
    * Haciendo click en el fichero mvnw.cmd de la raiz del proyecto. Se descargarán todas las dependencias y se levantará la aplicación. 
    
  Previamente hay que editar el fichero properties con las propiedades de conexión a la BBDD que hayamos levantado en local. Los ficheros SQL (de ejecución normal y de rollback) se encuentran al lado del fichero properties en la siguiente ruta: 'aktios/src/main/resources'.
