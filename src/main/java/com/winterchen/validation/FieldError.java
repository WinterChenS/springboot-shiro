package com.winterchen.validation;

import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.ObjectError;

/**
 * Created by Donghua.Chen on 2018/3/8.
 */
public class FieldError extends ObjectError {
    private final String field;
    private final Object rejectedValue;
    private final boolean bindingFailure;

    public FieldError(String objectName, String field, String defaultMessage) {
        this(objectName, field, (Object)null, false, (String[])null, (Object[])null, defaultMessage);
    }

    public FieldError(String objectName, String field, Object rejectedValue, boolean bindingFailure, String[] codes, Object[] arguments, String defaultMessage) {
        super(objectName, codes, arguments, defaultMessage);
        Assert.notNull(field, "Field must not be null");
        this.field = field;
        this.rejectedValue = rejectedValue;
        this.bindingFailure = bindingFailure;
    }

    public String getField() {
        return this.field;
    }

    public Object getRejectedValue() {
        return this.rejectedValue;
    }

    public boolean isBindingFailure() {
        return this.bindingFailure;
    }

    public String toString() {
        return "Field error in object '" + this.getObjectName() + "' on field '" + this.field + "': rejected value [" + this.rejectedValue + "]; " + this.resolvableToString();
    }

    public boolean equals(Object other) {
        if(this == other) {
            return true;
        } else if(!super.equals(other)) {
            return false;
        } else {
            org.springframework.validation.FieldError otherError = (org.springframework.validation.FieldError)other;
            return this.getField().equals(otherError.getField()) && ObjectUtils.nullSafeEquals(this.getRejectedValue(), otherError.getRejectedValue()) && this.isBindingFailure() == otherError.isBindingFailure();
        }
    }

    public int hashCode() {
        int hashCode = super.hashCode();
        hashCode = 29 * hashCode + this.getField().hashCode();
        hashCode = 29 * hashCode + ObjectUtils.nullSafeHashCode(this.getRejectedValue());
        hashCode = 29 * hashCode + (this.isBindingFailure()?1:0);
        return hashCode;
    }
}
