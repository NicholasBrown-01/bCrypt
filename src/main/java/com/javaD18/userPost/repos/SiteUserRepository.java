package com.javaD18.userPost.repos;

import com.javaD18.userPost.models.SiteUserClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteUserRepository extends JpaRepository<SiteUserClass, Long> {
    public SiteUserClass findSiteUserClassByUserName(String userName);
}
