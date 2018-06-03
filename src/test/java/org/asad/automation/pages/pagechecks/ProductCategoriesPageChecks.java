package org.asad.automation.pages.pagechecks;

import org.asad.automation.pages.ProductCategoriesPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class ProductCategoriesPageChecks {
    @Autowired
    private ProductCategoriesPage productCategoriesPage;

    private List<String> getSubdepartmentsAndCategories(String subdepartment, String departmentsLocator) {
        return Arrays.asList(productCategoriesPage.getSubdepartments(departmentsLocator)
                .stream()
                .filter(s1 -> s1.contains(subdepartment))
                .collect(Collectors.toList())
                .toString()
                .replaceAll("[\\[\\]]", "")
                .split("\n"));
    }

    public void checkSubDepartments(String subDepartment, String subDepartmentsLocator) {
        List<String> actualSubDepartments = getSubdepartmentsAndCategories(subDepartment, subDepartmentsLocator)
                .stream()
                .filter(s -> s.contains(subDepartment))
                .collect(Collectors.toList());
        List<String> expectedSubDepartment = Arrays.asList(subDepartment);
        assertThat(actualSubDepartments, is(expectedSubDepartment));
    }

    public void checkSubDepartmentalCategories(String expectedcategories, String subDepartment, String subDepartmentsLocator) {
        List<String> actualSubDepartmentalCategories = getSubdepartmentsAndCategories(subDepartment, subDepartmentsLocator)
                .stream()
                .filter(s -> !s.contains(subDepartment))
                .collect(Collectors.toList());
        List<String> expectedSubDepartmentalCategories = Arrays.asList(expectedcategories.split(", "));
        assertThat(actualSubDepartmentalCategories, is(expectedSubDepartmentalCategories));
    }
}
