# Spring Basics

# Get Call

# Post Call

### With Map as Request Body

```json
{
  "values":["10","12.5","50","100"]
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

Corresponding Java class to catch the request Body

```java
public class StudentRequestBody {
    private int count;
    @JsonProperty("studentIds")//If the name in the request body differs from variable name
    private List<String> studentIdList;
    private String greeting;
}
```

