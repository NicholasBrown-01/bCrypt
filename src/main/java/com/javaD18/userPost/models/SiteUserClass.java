package com.javaD18.userPost.models;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.util.List;


    @Entity
    public class SiteUserClass {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        long id;
        String userName;
        String userPassword;
        @OneToMany(mappedBy = "siteUserClass")
        List<PostClass> postsArray;

        protected SiteUserClass() {
        }

        public SiteUserClass(String userName, String userPassword) {
            this.userName = userName;
            this.userPassword = userPassword;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserPassword() {
            return userPassword;
        }

        public void setUserPassword(String userPassword) {
            this.userPassword = userPassword;
        }

        public List<PostClass> getPostsArray() {
            return postsArray;
        }

        public void setPostsArray(List<PostClass> postsArray) {
            this.postsArray = postsArray;
        }

        @Override
        public String toString() {
            return "SiteUser{" +
                    "id=" + id +
                    ", userName='" + userName + '\'' +
                    ", userPassword='" + userPassword + '\'' +
                    ", postsArray=" + postsArray +
                    '}';
        }
}
