# Stereotype Annotations
```java
@Component 
@Controller 
@Service
@Repository
```


```java
@JsonProperty("studentIds")//If the name in the request body differs from variable name
 private List<String> studentIdList;
```

Request Mapping
```java
   @RequestMapping(method= RequestMethod.GET,path="/requestMapping")
```

GetMapping
```java
@GetMapping(path="/getMapping")
```


Read the Path Variable
`@PathVariable` in the method parameter

```java
@GetMapping("/student/{studentId}")
public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) {
    return ResponseEntity.ok(studentService.getStudentById(userId));
}
```

Read the Request Body
`@RequestBody` in the method parameter


### Add Validation to the Request

User Entity Class (Using Lombok)
```java
@Data
public class User {
	private Integer id;
	@Size(min=2,message = "Names should be at least characters long")
	private String name;
	@Past(message = "DOB Cannot be in the Future")
	private Date dob;
}
```