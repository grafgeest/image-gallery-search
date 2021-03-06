package io.gitlab.agileengine.repository;

import io.gitlab.agileengine.model.Image;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ImageRepository extends CrudRepository<Image, String> {


    @Query("SELECT i FROM Image i WHERE i.author LIKE %:term% OR i.camera LIKE %:term% OR i.tags LIKE %:term%")
    List<Image> searchTerm(@Param("term")String term);

    @Modifying
    @Transactional
    @Query(value = "truncate table Image", nativeQuery = true)
    void truncateImageTable();

}
