package xyz.discordboats.Boats4J;

import java.util.Objects;

public class BotInfo {
    private String id;
    private String name;
    private String prefix;
    private String lib;
    private long server_count;
    private String shortDesc;
    private String desc;
    private String avatar;
    private String ownerid;
    private String ownername;
    private String invite;
    private String discord;
    private String website;
    private String inQueue;
    private String certified;

    BotInfo(String id, String name, String prefix, String lib, long server_count, String shortDesc, String desc, String avatar, String ownerid, String ownername, String invite, String discord, String website, String inQueue, String certified) {
        this.id = id;
        this.name = name;
        this.prefix = prefix;
        this.lib = lib;
        this.server_count = server_count;
        this.shortDesc = shortDesc;
        this.desc = desc;
        this.avatar = avatar;
        this.ownerid = ownerid;
        this.ownername = ownername;
        this.invite = invite;
        this.discord = discord;
        this.website = website;
        this.inQueue = inQueue;
        this.certified = certified;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getLib() {
        return lib;
    }

    public long getServer_count() {
        return server_count;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public String getDesc() {
        return desc;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getOwnerid() {
        return ownerid;
    }

    public String getOwnername() {
        return ownername;
    }

    public String getInvite() {
        return invite;
    }

    public String getDiscord() {
        return discord;
    }

    public String getWebsite() {
        return website;
    }

    public String getInQueue() {
        return inQueue;
    }

    public String getCertified() {
        return certified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BotInfo botInfo = (BotInfo) o;
        return server_count == botInfo.server_count &&
                Objects.equals(id, botInfo.id) &&
                Objects.equals(name, botInfo.name) &&
                Objects.equals(prefix, botInfo.prefix) &&
                Objects.equals(lib, botInfo.lib) &&
                Objects.equals(shortDesc, botInfo.shortDesc) &&
                Objects.equals(desc, botInfo.desc) &&
                Objects.equals(avatar, botInfo.avatar) &&
                Objects.equals(ownerid, botInfo.ownerid) &&
                Objects.equals(ownername, botInfo.ownername) &&
                Objects.equals(invite, botInfo.invite) &&
                Objects.equals(discord, botInfo.discord) &&
                Objects.equals(website, botInfo.website) &&
                Objects.equals(inQueue, botInfo.inQueue) &&
                Objects.equals(certified, botInfo.certified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, prefix, lib, server_count, shortDesc, desc, avatar, ownerid, ownername, invite, discord, website, inQueue, certified);
    }

    @Override
    public String toString() {
        return "BotInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", prefix='" + prefix + '\'' +
                ", lib='" + lib + '\'' +
                ", server_count=" + server_count +
                ", shortDesc='" + shortDesc + '\'' +
                ", desc='" + desc + '\'' +
                ", avatar='" + avatar + '\'' +
                ", ownerid='" + ownerid + '\'' +
                ", ownername='" + ownername + '\'' +
                ", invite='" + invite + '\'' +
                ", discord='" + discord + '\'' +
                ", website='" + website + '\'' +
                ", inQueue='" + inQueue + '\'' +
                ", certified='" + certified + '\'' +
                '}';
    }
}
