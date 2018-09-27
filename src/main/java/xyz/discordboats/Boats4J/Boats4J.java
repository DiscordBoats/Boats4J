package xyz.discordboats.Boats4J;

import net.dv8tion.jda.bot.sharding.ShardManager;
import net.dv8tion.jda.core.JDA;
import okhttp3.*;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * The main class
 */
public class Boats4J {
    private final String token;
    private final String botid;
    private static final OkHttpClient client = new OkHttpClient();;
    private static final String url = "https://discordboats.xyz/api";
    private static final Logger log = LoggerFactory.getLogger(Boats4J.class);

    /**
     * Default Constructor
     * @param token API token
     * @param botid Your bot's id
     */
    public Boats4J(String token, String botid) {
        this.token = token;
        this.botid = botid;
    }

    /**
     * Secondary Constructor
     * this one has auto server posting
     * @param jda JDA
     * @param token your token
     */
    public Boats4J(JDA jda, String token) {
        this.token = token;
        this.botid = jda.getSelfUser().getId();
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(()->postStats(jda, token), 0, 20, TimeUnit.MINUTES);
    }

    /**
     * Secondary Constructor
     * this one has auto server posting
     * @param sm ShardManager
     * @param token your token
     */
    public Boats4J(ShardManager sm, String token, String botid) {
        this.token = token;
        this.botid = botid;
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(()->postStats(sm, token), 0, 20, TimeUnit.MINUTES);
    }

    /**
     * Post stats to the api
     * @param server_count the server count
     */
    public void postStats(long server_count) {
        postStats(server_count, botid, token);
    }

    /**
     * Static way to post stats
     * @param server_count the server count
     * @param botid your bot's id
     * @param token API token
     */
    public static void postStats(long server_count, String botid, String token) {
        Request request = new Request.Builder().url(url+"/bot/"+botid)
                .addHeader("Authorization", token)
                .addHeader("content-type", "application/json")
                .post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), new JSONObject().put("server_count", server_count).toString())).build();
        try {
            client.newCall(request).execute().close();
            log.info("Successfully posted stats to discordboats.xyz");
        } catch (IOException e) {
            log.error("Failed to post stats to discordboats.xyz, Error: " + e.getMessage());
        }
    }

    /**
     * Static way to post stats
     * @param jda JDA object
     * @param token API token
     */
    public static void postStats(JDA jda, String token) {
        postStats(jda.getGuildCache().size(), jda.getSelfUser().getId(), token);
    }

    /**
     * Static way to post stats
     * @param sm ShardManager
     * @param token API token
     */
    public static void postStats(ShardManager sm, String token) {
        if (sm.getShards().isEmpty()) {
            throw new UnsupportedOperationException("You have no shards available!");
        }
        postStats(sm.getGuildCache().size(), sm.getShards().get(0).getSelfUser().getId(), token);
    }

    /**
     * Fetch bot info
     * @param id the id of the bot
     * @return the info of the bot
     */
    public static BotInfo fetchBotInfo(String id) {
        Request request = new Request.Builder().url(url + "/bot/"+id).get().build();
        try {
            Response resp = client.newCall(request).execute();
            ResponseBody body = resp.body();
            if (body == null) {
                return null;
            }
            JSONObject json = new JSONObject(body.string());
            BotInfo info = new BotInfo(json.getString("id"), json.getString("name"), json.getString("prefix"), json.getString("lib"), json.getLong("server_count"), json.getString("shortDesc"), json.getString("desc"), json.getString("avatar"), json.getString("ownerid"), json.getString("ownername"), json.getString("invite"), json.optString("discord"), json.optString("website"), json.getString("inQueue"), json.optString("certified"));
            body.close();
            resp.close();
            return info;
        } catch (IOException e) {
            log.error("Failed to fetch bot info for id: " + id +". Error: " + e.getMessage());
            return null;
        }
    }

    public static UserInfo fetchUserInfo(String id) {
        Request request = new Request.Builder().url(url + "/user/"+id).get().build();
        try {
            Response resp = client.newCall(request).execute();
            ResponseBody body = resp.body();
            if (body == null) {
                return null;
            }
            JSONObject json = new JSONObject(body.string());
            UserInfo info = new UserInfo(json.getString("id"), json.getString("name"), json.optString("website"), json.optString("twitter"), json.optString("github"), json.optString("instagram"), json.optString("reddit"), json.optString("bio"));
            body.close();
            resp.close();
            return info;
        } catch (IOException e) {
            log.error("Failed to fetch bot info for id: " + id +". Error: " + e.getMessage());
            return null;
        }
    }

}
