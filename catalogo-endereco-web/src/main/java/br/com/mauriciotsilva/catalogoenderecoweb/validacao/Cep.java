package br.com.mauriciotsilva.catalogoenderecoweb.validacao;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;

@NotNull
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CepValidador.class)
public @interface Cep {

	String message() default "";

	Class<?>[]groups() default {};

	Class<? extends Payload>[]payload() default {};

}
