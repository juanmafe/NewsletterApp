# Newsletter App

- Hexagonal architecture.
- Java 11.
- Tecnologies: Maven, Spring Boot, Spring Core, Mockito, Junit5, SpringRunner, Jacoco, Jpa, Spring Data, Mongo y Maria. 

- An UML. The reason for choosing a hexagonal architecture was for scalability, where you can choose different inputs, outputs and data resources.
![UML image](/newsletter/files/uml.png)

- An ER model, MariaDB and MongoDB under Docker have been used. The reason for choosing a relational database was (again) thinking about scalability (possibility of creating subcategories, newsletter for companies, etc). MongoDB has been used for a "news feed" function (the document of Mongo database selected just have two fields: "title" and "description").
![UML image](/newsletter/files/mer.png)

- Junit5, Mockito and SpringRunner have been used for the unit tests. Only the classes that contain business logic have been tested (entities and DTOs have been excluded with an annotation). Jacoco has been used for the coverage and it is 100%.
![UML image](/newsletter/files/jacoco.png)


- The application has four REST services:

    * GET: /newsletter
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
    * GET: /news
       * Response (200):
         > [
             {
                 "id": "6139ccd8265938ab510b71d3",
                 "title": "Lanzamiento Windows 11",
                 "description": "Microsoft lanzará en octubre Windows 11"
             },
             {
                 "id": "6139ccd9265938ab510b71d4",
                 "title": "Lanzamiento Manjaro 20.1",
                 "description": "El equipo de Manjaro lanzó en agosto la version 20.1"
             }
           ]
    * POST: /newsletter
       * BodyRequest:
         > {
           "name" : "Prueba",
           "surname" : "Insert",
           "frequency" : {"id" : "1"},
           "technologies" : [{"id" : "1"}, {"id" : "2"}]
           }
       * Response (201):
         > 13
    * DELETE: /newsletter/10
        * Response (200).

- The installation can be done in two ways:
    * By importing the project from an IDE with Spring Boot support and starting it with one click.
    * By clicking on the mvnw script file in the root of the project. All dependencies will be downloaded and the application will be started. 
    
  Previously, it is necessary to edit the properties file with the connection properties of our local database. SQL files (rollback included) are located in the following path: '/resources/database'.
