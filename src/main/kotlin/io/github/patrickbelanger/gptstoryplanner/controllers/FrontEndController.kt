package io.github.patrickbelanger.gptstoryplanner.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

/* TODO TO BE DELETED */
@RestController
class FrontEndController {

        /* Temporary method */
        @GetMapping("/api/hello")
        fun hello(): String {
            return "Hello, the time at the server is now " + Date() + "\n"
        }

}