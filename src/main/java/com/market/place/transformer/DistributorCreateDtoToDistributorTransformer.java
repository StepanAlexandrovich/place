package com.market.place.transformer;

import com.market.place.dto.DistributorCreateDto;
import com.market.place.models.Distributor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DistributorCreateDtoToDistributorTransformer extends Transformer<Distributor,DistributorCreateDto>{
    private final UserCreateDtoToUserTransformer<Distributor> userCreateDtoToUserTransformer;

    @Override
    public Distributor transform(DistributorCreateDto distributorCreateDto) {
        Distributor distributor = new Distributor(userCreateDtoToUserTransformer.transform(distributorCreateDto));
        distributor.setName(distributorCreateDto.getName());

        distributor.setBan(true);

        return distributor;
    }

}
