
[https://nitinkc.github.io/spring/microservices/spring-revisions/](https://nitinkc.github.io/spring/microservices/spring-revisions/)

# Postgres DB Integration

The data source URL takes in the DB name and `?currentSchema` as the name of the schema

```yaml
spring.datasource.url=jdbc:postgresql://localhost:5432/mydb?currentSchema=test
spring.datasource.username= 
spring.datasource.password=

spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
spring.datasource.driver-class-name=org.postgresql.Driver
```

JpaRepository extendsCrudRepository and provides support for Pagination and Sorting.
### Custom query

With the Repository, custom queries can be added
```java
@Repository
@EnableJpaRepositories
@Qualifier("jpaStudentRepository")
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // Custom query - ONLY for Simple Queries,
    @Query(nativeQuery = true, value = "SELECT * from student s WHERE s.gender = null")
    List<Student> findMaleStudents();

```
`nativeQuery = true` ensures that it runs with Selected DB
```java
@Query(nativeQuery = true, value = "SELECT * from student s WHERE s.gender = 'Male'")
List<Student> findMaleStudents();
```

Instead of native queries, JPQL can be used
```java
// Custom query using JPQL - Java Persistence Query Language
@Query("SELECT s FROM Student s WHERE s.gender = 'Female'")
List<Student> findMaleStudentsJpql();
```

JPQL with Query parameter
```java
// Custom query, JPQL, with Query Parameter
@Query("SELECT s FROM Student s WHERE s.dob > :date")
List<Student> findByDobDateAfter(@Param("date") LocalDate date);
```


# PUT Calls

# Postgres Db On Conflict Insert Statement
```roomsql
insert into student 
(id, first_name, last_name, gender, cityofbirth, email, university, dob) 

values (1, 'Anjanette', 'Pietrzyk', 'Female', 'Ugljevik', 'apietrzyk0@wufoo.com', 'Sul Ross State University', '1972-01-30')
 
On CONFLICT(id) DO NOTHING;
```