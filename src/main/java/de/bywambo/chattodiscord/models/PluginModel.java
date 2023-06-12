package de.bywambo.chattodiscord.models;

/**
 * Representative Configuration object class, covering / representing plugin.yaml.
 * Getters, Setters & empty constructor are needed by Bukkit to detect this class.
 */
public class PluginModel {
    private String main;
    private Float version;
    private String name;
    private String description;
    private String author;
    private String website;
    private String prefix;

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public Float getVersion() {
        return version;
    }

    public void setVersion(Float version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public PluginModel() {
        // Empty on purpose, needed by bukkit to detect this class
    }
}
