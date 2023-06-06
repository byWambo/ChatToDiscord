package de.bywambo.chattodiscord.utils;

import de.bywambo.chattodiscord.config.ResponseCodes;
import org.bukkit.Bukkit;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connector {

    private Connector() {
        throw new IllegalStateException("Utility class");
    }

    // Sends a POST request to the given URL and returns the HTTP Response Code
    public static void sendToWebhook(URL url, String body) {
        try {
            HttpURLConnection postConnection = (HttpURLConnection) url.openConnection();
            postConnection.setRequestMethod("POST");
            postConnection.setRequestProperty("Content-Type", "application/json");

            postConnection.setDoOutput(true);
            OutputStream os = postConnection.getOutputStream();
            os.write(body.getBytes());
            os.flush();
            os.close();

            logWithStatusCode(postConnection.getResponseCode());

        } catch (IOException e) {
            Bukkit.getLogger().info(
                    String.format("[ERROR] Failed to connect to %s " +
                            "Please make sure you entered a correct URL and check your internet connection/firewall rules.", url)
            );
        }
    }

    private static void logWithStatusCode(int statusCode) {
        String msg;
        switch(statusCode) {
            case ResponseCodes.OK_NO_CONTENT:
                msg = "[INFO] Successfully sent to Discord!";
                break;

            case ResponseCodes.BAD_REQUEST:
                msg = "[ERROR] BAD REQUEST | Check if your customized message is correctly formatted!";
                break;

            case ResponseCodes.UNAUTHORIZED:
                msg = "[ERROR] UNAUTHORIZED | Please check for typos in your URL";
                break;

            case ResponseCodes.FORBIDDEN:
                // TODO Release Proxy Repo to bypass the "ban"
                msg = "[ERROR] FORBIDDEN | This normally doesn't happen on webhooks: " +
                        "Looks like the webhook was deleted or your IP is flagged/banned for abusing";
                break;

            case ResponseCodes.NOT_FOUND:
                msg = "[ERROR] NOT FOUND | Please check the URL";
                break;

            case ResponseCodes.TOO_MANY_REQUESTS:
                msg = "[INFO] Too many messages at a time. Message may be sent delayed";
                break;

            case ResponseCodes.GATEWAY_UNAVAILABLE:
                msg = "[ERROR] GATEWAY UNAVAILABLE | Discord is having problems. Couldn't send message";
                break;

            default:
                msg = "[ERROR] UNKNOWN STATUS CODE: " + statusCode + ". " +
                        "Please create a issue at https://github.com/byWambo/ChatToDiscord/issues containing this message";
                break;
        }

        Bukkit.getLogger().info(msg);
    }

}
