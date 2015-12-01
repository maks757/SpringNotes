package org.guts.model.exceptions;

import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * Created by Gutsulyak Vadim <guts.vadim@gmail.com>.
 */
public class FormException extends Exception {
    private List<ObjectError> errors;

    public FormException(List<ObjectError> errors) {
        super();
        this.errors = errors;
    }

    public List<ObjectError> getErrors() {
        return errors;
    }

    public void setErrors(List<ObjectError> errors) {
        this.errors = errors;
    }
}