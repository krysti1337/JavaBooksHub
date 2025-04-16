# JavaBooksHub
Personal project JavaBooksHyb

JavaBooksHub este o aplicatie web pentru gestionarea unei biblioteci digitale de carti in format PDF. Proiectul permite utilizatorilor sa-si creeze conturi, sa se autentifice, sa salveze carti preferate si sa le citeasca direct din browser.

Tech Stack

Backend: Java, Spring Boot, Spring Security, Spring Data JPA
Frontend: Vaadin Flow
Baza de date: PostgreSQL
Build Tool: Maven
Autentificare: Custom login/register, cu criptarea parolelor
Deploy: momentan local (cu optiune de extindere in cloud in viitor)

Functionalitati

Inregistrare cont (cu rol implicit USER)
Autentificare
Gestionare carti (adaugare, listare, citire PDF)
Stocare carti PDF local
Pagini construite in Vaadin

Cerinte pentru rulare

JDK 17+

PostgreSQL (versiune recomandata: 14+)

Maven

Instalare si rulare locala

Cloneaza proiectul:

git clone https://github.com/username/JavaBooksHub.git
cd JavaBooksHub

Configureaza baza de date in application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/java_books_hub
spring.datasource.username=postgres
spring.datasource.password=parola_ta

Ruleaza aplicatia:

mvn spring-boot:run
Acceseaza aplicatia:
http://localhost:8081

📖 In dezvoltare

Pagina de user
Pagina de admin
Pagina de cautare de carti
Pagina unde poti citi cartea care ai ales sa o citesti
Stocare PDF in cloud
Panou de administrare
Comentarii si recenzii la carti
Cautare si filtrare avansata
