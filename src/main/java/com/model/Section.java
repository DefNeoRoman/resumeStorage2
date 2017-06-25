package com.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Section implements Serializable{
    public abstract boolean equals(Object o);

    public abstract int hashCode();

    public abstract String toString();
}
