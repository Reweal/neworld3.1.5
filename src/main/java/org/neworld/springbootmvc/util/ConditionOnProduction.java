package org.neworld.springbootmvc.util;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Conditional(ConditionalOnProduction.class)
public @interface ConditionOnProduction {
}
