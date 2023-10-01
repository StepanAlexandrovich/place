package com.market.place.services;

import com.market.place.dto.DistributorCreateDto;
import com.market.place.models.Distributor;

import java.util.List;

public interface DistributorService {
    void createDistributor(DistributorCreateDto distributorCreateDto);

    List<Distributor> getAll();
}
