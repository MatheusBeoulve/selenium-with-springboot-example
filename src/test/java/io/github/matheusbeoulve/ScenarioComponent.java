package io.github.matheusbeoulve;

import io.cucumber.spring.ScenarioScope;
import org.springframework.boot.test.context.TestComponent;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@TestComponent
@ScenarioScope
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ScenarioComponent {}
