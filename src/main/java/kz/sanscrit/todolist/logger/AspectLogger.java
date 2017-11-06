package kz.sanscrit.todolist.logger;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectLogger {

    private static final Logger LOGGER = LoggerFactory.getLogger(AspectLogger.class);

    @After("execution(* kz.sanscrit.todolist.controller.TodolistController.*(..))")
    private void controllerDoingSomething() {
        LOGGER.info("something is going on");
    }

}
