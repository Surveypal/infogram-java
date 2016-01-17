
package net.infogram.api.content.infographic;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "id",
    "title",
    "theme_id",
    "published",
    "thumbnail_url",
    "date_modified",
    "user_profile",
    "publish_mode",
    "url",
    "embed_responsive",
    "embed_async"
})
public class InfograhicInfo {

    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("theme_id")
    private Integer themeId;
    @JsonProperty("published")
    private Boolean published;
    @JsonProperty("thumbnail_url")
    private String thumbnailUrl;
    @JsonProperty("date_modified")
    private String dateModified;
    @JsonProperty("user_profile")
    private String userProfile;
    @JsonProperty("publish_mode")
    private String publishMode;
    @JsonProperty("url")
    private String url;
    @JsonProperty("embed_responsive")
    private String embedResponsive;
    @JsonProperty("embed_async")
    private String embedAsync;

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The title
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The themeId
     */
    @JsonProperty("theme_id")
    public Integer getThemeId() {
        return themeId;
    }

    /**
     * 
     * @param themeId
     *     The theme_id
     */
    @JsonProperty("theme_id")
    public void setThemeId(Integer themeId) {
        this.themeId = themeId;
    }

    /**
     * 
     * @return
     *     The published
     */
    @JsonProperty("published")
    public Boolean getPublished() {
        return published;
    }

    /**
     * 
     * @param published
     *     The published
     */
    @JsonProperty("published")
    public void setPublished(Boolean published) {
        this.published = published;
    }

    /**
     * 
     * @return
     *     The thumbnailUrl
     */
    @JsonProperty("thumbnail_url")
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    /**
     * 
     * @param thumbnailUrl
     *     The thumbnail_url
     */
    @JsonProperty("thumbnail_url")
    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    /**
     * 
     * @return
     *     The dateModified
     */
    @JsonProperty("date_modified")
    public String getDateModified() {
        return dateModified;
    }

    /**
     * 
     * @param dateModified
     *     The date_modified
     */
    @JsonProperty("date_modified")
    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    /**
     * 
     * @return
     *     The userProfile
     */
    @JsonProperty("user_profile")
    public String getUserProfile() {
        return userProfile;
    }

    /**
     * 
     * @param userProfile
     *     The user_profile
     */
    @JsonProperty("user_profile")
    public void setUserProfile(String userProfile) {
        this.userProfile = userProfile;
    }

    /**
     * 
     * @return
     *     The publishMode
     */
    @JsonProperty("publish_mode")
    public String getPublishMode() {
        return publishMode;
    }

    /**
     * 
     * @param publishMode
     *     The publish_mode
     */
    @JsonProperty("publish_mode")
    public void setPublishMode(String publishMode) {
        this.publishMode = publishMode;
    }

    /**
     * 
     * @return
     *     The url
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The embedResponsive
     */
    @JsonProperty("embed_responsive")
    public String getEmbedResponsive() {
        return embedResponsive;
    }

    /**
     * 
     * @param embedResponsive
     *     The embed_responsive
     */
    @JsonProperty("embed_responsive")
    public void setEmbedResponsive(String embedResponsive) {
        this.embedResponsive = embedResponsive;
    }

    /**
     * 
     * @return
     *     The embedAsync
     */
    @JsonProperty("embed_async")
    public String getEmbedAsync() {
        return embedAsync;
    }

    /**
     * 
     * @param embedAsync
     *     The embed_async
     */
    @JsonProperty("embed_async")
    public void setEmbedAsync(String embedAsync) {
        this.embedAsync = embedAsync;
    }

}
