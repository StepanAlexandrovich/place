package com.market.place.services.impl;

import com.market.place.dto.DistributorCreateDto;
import com.market.place.models.Distributor;
import com.market.place.repositories.DistributorRepository;
import com.market.place.repositories.UserRoleRepository;
import com.market.place.services.DistributorService;
import com.market.place.transformer.DistributorCreateDtoToDistributorTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DistributorServiceImpl implements DistributorService {
    private final DistributorRepository distributorRepository;
    private final DistributorCreateDtoToDistributorTransformer distributorCreateDtoToDistributorTransformer;
    private final UserRoleRepository userRoleRepository;

    @Override
    public void createDistributor(DistributorCreateDto distributorCreateDto) {
        Distributor distributor = distributorCreateDtoToDistributorTransformer.transform(distributorCreateDto);
        distributor.setUserRole(userRoleRepository.findByRole("ROLE_DISTRIBUTOR"));
        distributorRepository.save(distributor);
    }

    @Override
    public List<Distributor> getAll() {
        return distributorRepository.findAll();
    }
}
