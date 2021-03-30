package com.skillovilla.getpricemodule.repository;

import com.skillovilla.getpricemodule.domainobject.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CourseRepository extends CrudRepository<Course,Long> {
}
