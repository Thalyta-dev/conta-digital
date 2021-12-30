package br.com.lookbank.contadigital.contadigital.anotattion;

import br.com.lookbank.contadigital.contadigital.domain.Pessoa;
import br.com.lookbank.contadigital.contadigital.validacao.MaiorIdadadeValidator;
import br.com.lookbank.contadigital.contadigital.validacao.UniqueValueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MaiorIdadadeValidator.class)
public @interface MaiorIdade {
    String message() default  "Pessoa menor de 18 anos";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String fieldName() default "dataNascimento";
    Class<?> domainClass() default Pessoa.class;
}