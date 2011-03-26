package de.sample.interceptors;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;
import java.lang.annotation.*;
import javax.interceptor.*;
 
@Inherited
@InterceptorBinding
@Retention(RUNTIME)
@Target({TYPE, METHOD})
public @interface AuditTime {
}