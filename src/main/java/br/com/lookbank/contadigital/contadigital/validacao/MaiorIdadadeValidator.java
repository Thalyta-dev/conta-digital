package br.com.lookbank.contadigital.contadigital.validacao;

import br.com.lookbank.contadigital.contadigital.anotattion.MaiorIdade;
import br.com.lookbank.contadigital.contadigital.anotattion.UniqueValue;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Year;
import java.util.List;

public class MaiorIdadadeValidator implements ConstraintValidator<MaiorIdade, LocalDate> {

    private String domainAttibute;
    private Class<?> aClass;


    public void initialize(MaiorIdade constraintAnnotation) {
        this.aClass = constraintAnnotation.domainClass();
        this.domainAttibute = constraintAnnotation.fieldName();
    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        return LocalDate.now().getYear() - localDate.getYear()  >= 18;
    }
}