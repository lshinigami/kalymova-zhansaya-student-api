package kz.iitu.studentapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class InfoController {

    @Value("${app.student}")
    private String student;

    @Value("${app.version}")
    private String version;

    @GetMapping("/api/info")
    public Map<String, String> info() {
        return Map.of("student", student, "version", version, "app", "kalymova-zhansaya-student-api");
    }
}
