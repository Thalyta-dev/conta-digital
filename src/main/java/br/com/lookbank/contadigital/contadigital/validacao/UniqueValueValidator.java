package br.com.lookbank.contadigital.contadigital.validacao;

import br.com.lookbank.contadigital.contadigital.anotattion.UniqueValue;
import br.com.lookbank.contadigital.contadigital.repository.PessoaPersistencia;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

    private String domainAttibute;
    private Class<?> aClass;

    @PersistenceContext
    private EntityManager manager;


    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        this.aClass = constraintAnnotation.domainClass();
        this.domainAttibute = constraintAnnotation.fieldName();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Query query = manager.createQuery("select 1 from " + aClass.getName() + " where " + domainAttibute + " =:value");
        query.setParameter("value", o);
        List<?> lista = query.getResultList();
        return  lista.isEmpty();

    }
}