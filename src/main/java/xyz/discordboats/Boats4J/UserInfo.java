package xyz.discordboats.Boats4J;

import java.util.Objects;

public class UserInfo {
    private String id;
    private String name;
    private String website;
    private String twitter;
    private String github;
    private String instagram;
    private String reddit;
    private String bio;

    UserInfo(String id, String name, String website, String twitter, String github, String instagram, String reddit, String bio) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.twitter = twitter;
        this.github = github;
        this.instagram = instagram;
        this.reddit = reddit;
        this.bio = bio;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWebsite() {
        return website;
    }

    public String getTwitter() {
        return twitter;
    }

    public String getGithub() {
        return github;
    }

    public String getInstagram() {
        return instagram;
    }

    public String getReddit() {
        return reddit;
    }

    public String getBio() {
        return bio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(id, userInfo.id) &&
                Objects.equals(name, userInfo.name) &&
                Objects.equals(website, userInfo.website) &&
                Objects.equals(twitter, userInfo.twitter) &&
                Objects.equals(github, userInfo.github) &&
                Objects.equals(instagram, userInfo.instagram) &&
                Objects.equals(reddit, userInfo.reddit) &&
                Objects.equals(bio, userInfo.bio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, website, twitter, github, instagram, reddit, bio);
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", website='" + website + '\'' +
                ", twitter='" + twitter + '\'' +
                ", github='" + github + '\'' +
                ", instagram='" + instagram + '\'' +
                ", reddit='" + reddit + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
}
