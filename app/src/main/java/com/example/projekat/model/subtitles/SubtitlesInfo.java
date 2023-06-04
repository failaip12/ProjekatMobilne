package com.example.projekat.model.subtitles;



import java.util.regex.Pattern;

public class SubtitlesInfo {
    private static final Pattern fmtRegex = Pattern.compile("&fmt=[^&]*");
    private static final Pattern tlangRegex = Pattern.compile("&tlang=[^&]*");

    private final String url;
    private final String language;
    private final boolean isAutoGenerated;
    private final boolean fromCaptions;

    public SubtitlesInfo(String url, String language, boolean isAutoGenerated) {
        this(url, language, isAutoGenerated, false);
    }

    public SubtitlesInfo(String url, String language, boolean isAutoGenerated, boolean fromCaptions) {
        String filteredUrl = fmtRegex.matcher(url).replaceAll(""); // existing format
        filteredUrl = tlangRegex.matcher(filteredUrl).replaceAll(""); // existing translation language
        this.url = filteredUrl;
        this.language = language;
        this.isAutoGenerated = isAutoGenerated;
        this.fromCaptions = fromCaptions;
    }

    public String getUrl() {
        return url;
    }

    public String getLanguage() {
        return language;
    }

    public boolean isAutoGenerated() {
        return isAutoGenerated;
    }

    public boolean isFromCaptions() {
        return fromCaptions;
    }

}
