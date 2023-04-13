package com.example.unimeet3;

public class Profile {
    private String age, bio, email, major, pic;

    private String[] classes = new String[6];
    private String[] hobbies = new String[6];
    private String[] orgs = new String[3];

    public Profile() {

    }
    public Profile(String age, String bio, String email, String major, String pic, String[] classes, String[] hobbies, String[] orgs) {
        this.age = age;
        this.bio = bio;
        this.email = email;
        this.major = major;
        this.pic = pic;
        this.classes = classes;
        this.hobbies = hobbies;
        this.orgs = orgs;
    }
}
