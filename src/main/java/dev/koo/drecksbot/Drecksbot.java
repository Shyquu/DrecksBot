package dev.koo.drecksbot;

import dev.koo.commands.GambleCommand;
import dev.koo.utils.Discord;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.activity.ActivityType;

public class Drecksbot {

    private static DiscordApi api;

    public static void main(String[] args) {

        api = new DiscordApiBuilder().setToken(Discord.TOKEN).login().join();
        System.out.println("DrecksBot erfolgreich hochgefahren.");

        api.updateActivity(ActivityType.WATCHING, api.getServers().size() + " Servern zu");

        GambleCommand.Gambler();

    }

    public static DiscordApi getApi() {
        return api;
    }
}
