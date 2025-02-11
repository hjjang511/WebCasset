package com.project.webbackend.Controller;



import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.webbackend.Entity.Role;
import com.project.webbackend.Response.ResponseObject;
import com.project.webbackend.Service.role.RoleService;

import java.util.List;
import java.net.InetAddress;

@RestController
@RequestMapping("${api.prefix}/healthcheck")
@AllArgsConstructor
public class HealthCheckController {
    private final RoleService roleService;
    @GetMapping("/health")
    public ResponseEntity<ResponseObject> healthCheck() throws Exception{
        List<Role> roles = roleService.getAllRoles();
        // Get the computer name
        String computerName = InetAddress.getLocalHost().getHostName();
        return ResponseEntity.ok(ResponseObject
                .builder()
                .message("ok, Computer Name: " + computerName)
                .status(HttpStatus.OK)
                .build());
    }
}
