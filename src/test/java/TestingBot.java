import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import xyz.discordboats.Boats4J.Boats4J;

import javax.security.auth.login.LoginException;

public class TestingBot {
    public static void main(String[] args) {
        try {
            String botid = "";
            String bottoken = "";
            String apitoken = "";
            JDA jda = new JDABuilder().setToken(bottoken).build().awaitReady();
            new Boats4J(jda, apitoken);
            System.out.println(Boats4J.fetchBotInfo(botid));
            System.out.println(Boats4J.fetchUserInfo("239790360728043520"));
        } catch (LoginException | InterruptedException ignored) {
        }
    }
}
