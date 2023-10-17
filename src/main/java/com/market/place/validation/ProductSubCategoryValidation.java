package com.market.place.validation;

import com.market.place.models.ProductSubCategory;
import com.market.place.repositories.ProductSubCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class ProductSubCategoryValidation implements Validator {
    private final ProductSubCategoryRepository productSubCategoryRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return ProductSubCategory.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductSubCategory productSubCategory = (ProductSubCategory) target;
        if(productSubCategoryRepository.findByName(productSubCategory.getName()).isPresent()){
            errors.rejectValue("name","not difference","this productSubCategory exists");
        }
    }
}
