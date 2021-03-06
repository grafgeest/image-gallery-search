package io.gitlab.agileengine.controller;

import io.gitlab.agileengine.model.Image;
import io.gitlab.agileengine.service.SearchService;
import io.gitlab.agileengine.service.impl.SearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    private SearchService searchService;

    @Autowired
    private void setSearchService(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping(value = "search/{searchTerm}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> search(@PathVariable("searchTerm") String searchTerm) {
        List<Image> images = searchService.searchImages(searchTerm);
        return ResponseEntity
                .ok()
                .body(images);
    }
}
