package com.example.parcial.UTILS;
import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class CompositeKey implements Serializable {
    private Long idPart1;
    private Long idPart2;

    // Constructor
    public CompositeKey() { }

    public CompositeKey(Long idPart1, Long idPart2) {
        this.idPart1 = idPart1;
        this.idPart2 = idPart2;
    }

    // Getters and setters
    public Long getIdPart1() {
        return idPart1;
    }

    public void setIdPart1(Long idPart1) {
        this.idPart1 = idPart1;
    }

    public Long getIdPart2() {
        return idPart2;
    }

    public void setIdPart2(Long idPart2) {
        this.idPart2 = idPart2;
    }

    // Override equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompositeKey that = (CompositeKey) o;

        if (!idPart1.equals(that.idPart1)) return false;
        return idPart2.equals(that.idPart2);
    }

    @Override
    public int hashCode() {
        int result = idPart1.hashCode();
        result = 31 * result + idPart2.hashCode();
        return result;
    }
}
