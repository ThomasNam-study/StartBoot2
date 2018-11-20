package kr.purred.startboot2.model.calc;

import java.lang.annotation.*;

@Target ({ElementType.METHOD, ElementType.TYPE})
@Retention (RetentionPolicy.RUNTIME)
@Documented
public @interface LoggingRequired
{
}
