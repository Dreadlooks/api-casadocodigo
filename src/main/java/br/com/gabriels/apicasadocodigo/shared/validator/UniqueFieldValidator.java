package br.com.gabriels.apicasadocodigo.shared.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public abstract class UniqueFieldValidator<T> implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Object.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {

         Optional<?> possibleField = getFieldToSearch((T)object);

         if (possibleField.isPresent()) {
             String invalidField = getInvalidField();
             errors.rejectValue(invalidField, null, invalidField + ": Ja existe um " + invalidField + " com esse nome!");
         }
    }

    public abstract Optional<T> getFieldToSearch(T object);

    public abstract String getInvalidField();
}
