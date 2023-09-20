# Stereotype Annotations

> Basic philosophy : Conventions over configurations

```java
@Component 
@Controller 
@Service
@Repository
```

## Controller Vs RestController

Controller needs `@ResponseBody` with method name
```java
@Controller
@RequestMapping("/health")
public class HealthCheckController {
    @RequestMapping(path = "/check", method = RequestMethod.GET)
    public @ResponseBody String hello(){
        return "Health is Ok";
    }
}
```

```java
 @RequestMapping(path = "/requestMapping/{studentId}",
            produces = { "application/json", MediaType.APPLICATION_XML_VALUE,  MediaType.APPLICATION_PDF_VALUE})
public @ResponseBody StudentDto getStudentByIdRequestMapping(@PathVariable String studentId){
        ...
}
```

## Scans

Entity Scan vs

```java
@EntityScan(basePackages = {"com.learningJPA.dSpringDataRepository"
        ,"com.learningJPA.eTest.model"
        //,"com.learningJPA.hibernate.*"
}) 
```

What is this??
```java
@SpringBootApplication(
    scanBasePackages = {
        "com.test.package1",
        "com.test.service.security"
    },
    exclude = { JmxAutoConfiguration.class })
```

ComponentScan

```java
@ComponentScan(basePackages = {
        "com.test.animals", 
        "com.flowers"
})
```

## Autowired Dependency Injection

Eliminates the need of creating a new object and hence the need of constructors from the components

`StudentService studentService = new StudentService();`
```java
@Autowired
StudentService studentService;//Free to use studentService object within the class anywhere
```

# Mappings

### GetMapping

```java
@RequestMapping(method= RequestMethod.GET,path="/requestMapping")
```

```java
@GetMapping(
        value = "/{studentId}", 
        path = "/{studentId}",
        consumes = {MediaType.TEXT_PLAIN_VALUE, MediaType.APPLICATION_JSON_VALUE},
        produces = { "application/json", MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_PDF_VALUE}
)
```

### Difference between PathVariable and RequestParam


##### Read the Path Variable

`@PathVariable` in the method parameter

```java
@GetMapping("/student/{studentId}")
public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) {
    return ResponseEntity.ok(studentService.getStudentById(userId));
}
```

##### Reading via RequestParam

> ```javascript
> /jpa/students/pagination?pageSize=5&pageNo=1&sortBy=email
> ```

```java
// Retrieve all users page by page
@GetMapping(path = "/students/pagination")
public List<Student> 
    retrieveAllUsersPagination(@RequestParam(defaultValue = "0") Integer pageNo,
                                                @RequestParam(defaultValue = "10") Integer pageSize,
                                                @RequestParam(defaultValue = "id") String sortBy) {
        ...
}
```

### POST Mappings

Read the request body using `@RequestBody ` into either a Map, for simple structures or a class for complex

### With Map as Request Body

if request body is like below, a map can be used
```json
{
  "values":["10","12.5","50","100"]
}
```

```java
@PostMapping(path = "/studentIdsByMap",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {"application/json"})
public List<StudentDto> getStudentByIdsByMap(@RequestBody Map<String,List<Integer>> mapStudentIds){
        ...
}
```


### With Class as Request Body

```json
{
    "greeting":"F",
    "count":10,
    "studentIds":["10","12.5","50","111"]
}
```

```java
@PostMapping(path = "/studentIdsByClassName",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {"application/json"})
public StudentDtoClass getStudentByIdsRequestBody(@RequestBody StudentRequestBody studentRequestBody){
        ...
}
```
Corresponding Java class to catch the request Body

```java
public class StudentRequestBody {
    private int count;
    @JsonProperty("studentIds")//If the name in the request body differs from variable name
    private List<String> studentIdList;
    private String greeting;
}
```



# Simple Jackson Mapping

```java
@JsonProperty("studentIds")//If the name in the request body differs from variable name
 private List<String> studentIdList;
```


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