package vn.edu.huce.ltudm.cassette.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import vn.edu.huce.ltudm.cassette.Entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {

}
