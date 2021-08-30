package com.system.application.pizzaria.endpoint;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
}
