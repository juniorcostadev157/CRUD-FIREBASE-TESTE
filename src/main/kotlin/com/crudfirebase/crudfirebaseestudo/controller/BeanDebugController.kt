package com.crudfirebase.crudfirebaseestudo.controller

import org.springframework.context.ApplicationContext
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BeanDebugController {

    @GetMapping("/beans")
    fun listBeans(context: ApplicationContext): List<String> {
        return context.beanDefinitionNames.sorted()
    }
}
