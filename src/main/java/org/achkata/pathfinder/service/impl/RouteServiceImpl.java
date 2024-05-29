package org.achkata.pathfinder.service.impl;

import org.achkata.pathfinder.model.dto.RouteShortInfoDTO;
import org.achkata.pathfinder.model.entity.Picture;
import org.achkata.pathfinder.model.entity.Route;
import org.achkata.pathfinder.repository.RouteRepository;
import org.achkata.pathfinder.service.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service

public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;
    private final Random random;
    private final ModelMapper modelMapper;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository, Random random, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.random = random;
        this.modelMapper = new ModelMapper();
    }
    @Transactional
    @Override
    public RouteShortInfoDTO getRandomRoute() {
        long routeCount = routeRepository.count();
        long randomId = random.nextLong(routeCount) + 1;
        Optional<Route> byId = routeRepository.findById(randomId);

        return mapToShortInfo(byId.get());
    }
    @Transactional
    @Override
    public List<RouteShortInfoDTO> getAll() {
        return routeRepository.findAll()
                .stream()
                .map(this::mapToShortInfo)
                .toList();

    }

    private RouteShortInfoDTO mapToShortInfo(Route route) {
        RouteShortInfoDTO dto = modelMapper.map(route, RouteShortInfoDTO.class);

        Optional<Picture> first = route.getPictures().stream().findFirst();
        dto.setImageUrl(first.get().getUrl());
        return dto;
    }
}
