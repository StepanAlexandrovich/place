package com.market.place.validation;

import com.market.place.models.ProductCategory;
import com.market.place.repositories.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class ProductCategoryValidation implements Validator {
    private final ProductCategoryRepository productCategoryRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return ProductCategory.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductCategory productCategory = (ProductCategory) target;
        if(productCategoryRepository.findByName(productCategory.getName()).isPresent()){
            errors.rejectValue("name","not difference","this productCategory exists");
        }
    }
}
