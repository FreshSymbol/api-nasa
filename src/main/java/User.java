import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private String copyright;
    private String date;
    private String explanation;
    private String hdUrl;
    private String mediaType;
    private String serviceVersion;
    private String title;
    private String url;

    public User(@JsonProperty ("copyright") String  copyright,
                @JsonProperty ("date") String date,
                @JsonProperty ("explanation") String explanation,
                @JsonProperty ("hdurl") String hdUrl,
                @JsonProperty ("media_type") String mediaType,
                @JsonProperty ("service_version") String serviceVersion,
                @JsonProperty ("title") String title,
                @JsonProperty ("url") String url) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdUrl = hdUrl;
        this.mediaType = mediaType;
        this.serviceVersion = serviceVersion;
        this.title = title;
        this.url = url;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getDate() {
        return date;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getHdUrl() {
        return hdUrl;
    }

    public String getMediaType() {
        return mediaType;
    }

    public String getServiceVersion() {
        return serviceVersion;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return
                "copyright='" + copyright + '\'' +
                ", date='" + date + '\'' +
                ", explanation='" + explanation + '\'' +
                ", hdUrl='" + hdUrl + '\'' +
                ", mediaType='" + mediaType + '\'' +
                ", serviceVersion='" + serviceVersion + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'';
    }
}
