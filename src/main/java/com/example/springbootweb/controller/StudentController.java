package com.example.springbootweb.controller;

import com.example.springbootweb.exception.IdNotFoundException;
import com.example.springbootweb.model.Student;
import com.example.springbootweb.service.Studentservice;
import com.example.springbootweb.utility.JwtUtility;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping(value = "/v1/boot")
@RestController
@RequiredArgsConstructor
//@Profile("dev")//only create bean if application.properties file spring.profiles.active=dev
//@PropertySource("classpath:application.properties")// this annotation is used in @Configuration file
//@PropertySource("classpath:application-dev.properties")
public class StudentController {

    @Value("${server.port}")
    String port;
    @Value("${message}")
    String message;
    private final Studentservice studentservice;
    private final JwtUtility jwtUtility;

//    @Autowired
//    Environment env;
//    @Bean
//    public DBConnection getDBConnection() {// its is getting data from properties file which is defined in @PropertySource
//        System.out.println("Getting DBConnection Bean for App: "+env.getProperty("APP_NAME"));
//        DBConnection dbConnection = new DBConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"), env.getProperty("spring.datasource.password"), env.getProperty("spring.datasource.driver-class-name").toCharArray());
//        return dbConnection;
//    }


    //With constructor injection, dependencies can be made immutable by marking them as final, ensuring that once they are set, they cannot be changed.
    // This helps in creating immutable objects, which can lead to better thread safety and easier reasoning about the state of the object.
    //
    //Guaranteed Dependencies: With constructor injection, all required dependencies are passed during object creation, ensuring that the object
    // is always in a valid state. This helps in preventing objects from being created in an incomplete or invalid state, leading to fewer runtime errors.
    //
    //Testability: Constructor injection makes it easier to write unit tests for classes because dependencies are passed explicitly.
    // This makes it straightforward to mock or stub dependencies during testing, leading to more isolated and reliable tests.


    @GetMapping("/")
    public String get() {
        return "Hello Spring boot Profile active :"+message;
    }

    //@Secured("ROLE_ADMIN")//ony ADMIN can access
    //@PreAuthorize("hasRole('ROLE_ADMIN')")//before entering method it checks authorize or not
    //@PostAuthorize("hasRole('ROLE_ADMIN')")//first execute method then check authorization if not AccessDeniedException

    @PostMapping("/save")
    public ResponseEntity<Object> saveStudent(@Valid @RequestBody Student student, BindingResult result) {
        try {
            if (result.hasErrors()) {
                Map<String, String> errors = new HashMap<>();
                result.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
                return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
            }
            else {
                Student student1 = studentservice.save(student);
                return ResponseEntity.status(HttpStatus.CREATED).body("data saved successfully:" + student1);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("data not saved: " + e.getMessage());
        }
    }
//    @PostConstruct
//    public void init()//@PostConstruct is an annotation used to mark a method that should be executed after a bean has been initialized,
//    // i.e., after its dependencies have been injected and before it is put into service.
//    {
//        // Initialization code here
//        System.out.println("Bean initialized profile is:---"+message);
//    }
//@PreDestroy
//public void cleanup()//@PreDestroy is an annotation used to mark a method that should be executed before a bean is removed from service,
//// typically during the shutdown phase of the application.
//{
//    // Cleanup code here
//    System.out.println("Bean being destroyed. Performing cleanup.");
//}

    @Operation(summary = "Get All Student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "text/plain")),
            @ApiResponse(responseCode = "404", description = "not found")
    })
    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getstudent")
    public List<Student> getStudent() {
        List<Student> list;
        list = studentservice.getStudent();
        log.info(String.valueOf(list.size()));
       // list.forEach(s->System.out.println(s));
//        list.stream().sorted(Comparator.comparing(Student::getName)).forEach(System.out::println);
//        list.stream().max(Comparator.comparingInt(Student::getId)).ifPresent(System.out::println);
//        list.stream().sorted(Comparator.comparingInt(Student::getId).reversed()).forEach(System.out::println);

        log.info("port-----Number:"+port);
        return list;

    }
    @GetMapping("/getstudentbyid/{id}")
    public ResponseEntity<Object> getStudentById(@PathVariable int id) {
        log.info("hello");

        try {
            Student st = studentservice.getStudentById(id);
            System.out.println("--------------------------"+st.toString());
            //log.info(st.toString());

            return ResponseEntity.status(HttpStatus.ACCEPTED).body(st);
        }
        catch(IdNotFoundException ex)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @GetMapping("/currentuser")
    public String currentUser(Principal principal)
    {
        return principal.getName();
    }


    //    @ExceptionHandler(IdNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public String handleIdNotFoundException(IdNotFoundException ex) {
//        return ex.getMessage();
//    }
    @GetMapping("/getstudentbyname")
    public ResponseEntity<Object> getStudentByName(@RequestParam String name) {

        try {
            List<Student> list= studentservice.getStudentByName(name);
            return ResponseEntity.ok(list);
        }
        catch(IdNotFoundException ex)
        {
            log.error(ex.nameNotFound());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.nameNotFound());
        }

    }
    @DeleteMapping("/delstudent/{id}")
    public ResponseEntity<Object> delStudentById(@PathVariable int id) {
        try {
            String str=studentservice.delStudentById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Student Deleted successfully by id: " + id);
        } catch (IdNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
    @PutMapping("/updatestudent")
    public ResponseEntity<Object> updateStudent(@RequestBody Student student)
    {
        try {
            Student s = studentservice.updateStudentById(student);
            return ResponseEntity.ok(s);
        }
        catch(IdNotFoundException ex)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }

    }

}
