package com.asunawesker.delete.provider;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delete")
public class DeleteController {

    // Endpoint that processes DELETE request with a body
    @DeleteMapping
    public Body delete(@RequestBody Body body) {
        System.out.println("BODY = " + body);
        return body;
    }
}
