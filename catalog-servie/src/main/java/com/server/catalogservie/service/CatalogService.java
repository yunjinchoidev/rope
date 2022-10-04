package com.server.catalogservie.service;

import com.server.catalogservie.jpa.CatalogEntity;

public interface CatalogService {
    Iterable<CatalogEntity> getAllCatalogs();
}
