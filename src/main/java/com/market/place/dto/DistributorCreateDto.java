package com.market.place.dto;

public class DistributorCreateDto extends UserCreateDto{
    private String name;
    public DistributorCreateDto() {}

//    public DistributorCreateDto(String login, String password) {
//        super(login, password);
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
