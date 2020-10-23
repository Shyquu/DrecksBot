package dev.koo.commands;

import dev.koo.drecksbot.Drecksbot;
import org.javacord.api.entity.message.embed.EmbedBuilder;

import java.awt.*;
import java.util.Random;

public class GambleCommand {

    public static void Gambler() {

        Drecksbot.getApi().addMessageCreateListener(event -> {

            String[] message = event.getMessage().getContent().split(" ");

            if (message[0].equalsIgnoreCase("db") && message[1].equalsIgnoreCase("gamble")) {

                Random random = new Random();

                int usr = random.nextInt(10);
                int bot = random.nextInt(10);

                EmbedBuilder win = new EmbedBuilder();
                win.setTitle("war nur glück");
                win.addField("test", "__Ergebnisse__");
                win.setFooter("TOOOOOOORRR");
                win.setColor(Color.YELLOW);
                win.addInlineField(event.getMessage().getAuthor().getName() + ":", "```" + usr + "```");
                win.addInlineField("Drecksbot", "```" + bot + "```");

                EmbedBuilder lose = new EmbedBuilder();
                lose.setTitle("yooo destruction 100");
                lose.addField("test", "__Ergebnisse__");
                lose.setFooter("pech");
                lose.setColor(Color.YELLOW);
                lose.addInlineField(event.getMessage().getAuthor().getName() + ":", "```" + usr + "```");
                lose.addInlineField("Drecksbot", "```" + bot + "```");

                if (usr < bot) {

                    event.getChannel().sendMessage(lose);

                } else
                    event.getChannel().sendMessage(win);

            }

        });

    }

}
