package com.yogesh.jpa_rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter @Setter
@AllArgsConstructor
public class EmployeeDTO {
    @JsonProperty("name")
    private String name;

    @JsonProperty("role")
    private String role;

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof EmployeeDTO))
            return false;
        EmployeeDTO employee = (EmployeeDTO) o;
        return Objects.equals(this.name, employee.name)
                && Objects.equals(this.role, employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.role);
    }

    @Override
    public String toString() {
        return "Employee{" + " name='" + this.name + '\'' + ", role='" + this.role + '\'' + '}';
    }
}
