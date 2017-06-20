package com.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OrganizationSection extends Section {
    private static final long serialVersionUID = 930687138367303158L;
    private  List<Organization> organizations = new ArrayList<>();
    public static final OrganizationSection EMPTY = new OrganizationSection();
    public OrganizationSection() {
    }

    public OrganizationSection(Organization...items) {
        this(Arrays.asList(items));
    }
    public OrganizationSection(List<Organization> organizations) {
        Objects.requireNonNull(organizations,"must be not null");
        this.organizations = organizations;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationSection that = (OrganizationSection) o;

        return organizations.equals(that.organizations);

    }

    @Override
    public int hashCode() {
        return organizations.hashCode();
    }

    @Override
    public String toString() {
        return organizations.toString();
    }
}
