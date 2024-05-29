package org.achkata.pathfinder.service;

import org.achkata.pathfinder.model.dto.RouteShortInfoDTO;
import org.achkata.pathfinder.model.entity.Route;

import java.util.List;

public interface RouteService {
    RouteShortInfoDTO getRandomRoute();
    List<RouteShortInfoDTO> getAll();
}
