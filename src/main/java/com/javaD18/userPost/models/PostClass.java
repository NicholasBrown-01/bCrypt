package com.javaD18.userPost.models;
import jakarta.persistence.*;


    @Entity
    public class PostClass {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        long id;
        String postID;
        String userID;
        String userText;

        @ManyToOne
        SiteUserClass siteUserClass;

        protected PostClass() {}

        public PostClass(String postID, String userID, String userText) {
            this.postID = postID;
            this.userID = userID;
            this.userText = userText;

        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getPostID() {
            return postID;
        }

        public void setPostID(String postID) {
            this.postID = postID;
        }

        public String getUserID() {
            return userID;
        }

        public void setUserID(String userID) {
            this.userID = userID;
        }

        public String getUserText() {
            return userText;
        }

        public void setUserText(String userText) {
            this.userText = userText;
        }

        public SiteUserClass getSiteUserClass() {
            return siteUserClass;
        }

        public void setSiteUserClass(SiteUserClass siteUserClass) {
            this.siteUserClass = siteUserClass;
        }

        @Override
        public String toString() {
            return "PostClass{" +
                    "id=" + id +
                    ", postID='" + postID + '\'' +
                    ", userID='" + userID + '\'' +
                    ", userText='" + userText + '\'' +
                    '}';
        }
    }
