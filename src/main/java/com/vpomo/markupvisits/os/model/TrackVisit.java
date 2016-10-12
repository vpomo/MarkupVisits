package com.vpomo.markupvisits.os.model;

/**
 * Created by Pomogalov on 12.10.2016.
 */
public class TrackVisit {
    private String baseURL;
    private String titlePageBase;
    private String clickOneURL;
    private String clickTwoURL;

    public TrackVisit() {
        this.baseURL = null;
        this.titlePageBase = null;
        this.clickOneURL = null;
        this.clickTwoURL = null;
    }

    public TrackVisit(String baseURL, String titlePageBase, String clickOneURL, String clickTwoURL) {
        this.baseURL = baseURL;
        this.titlePageBase = titlePageBase;
        this.clickOneURL = clickOneURL;
        this.clickTwoURL = clickTwoURL;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public String getTitlePageBase() {
        return titlePageBase;
    }

    public void setTitlePageBase(String titlePageBase) {
        this.titlePageBase = titlePageBase;
    }

    public String getClickOneURL() {
        return clickOneURL;
    }

    public void setClickOneURL(String clickOneURL) {
        this.clickOneURL = clickOneURL;
    }

    public String getClickTwoURL() {
        return clickTwoURL;
    }

    public void setClickTwoURL(String clickTwoURL) {
        this.clickTwoURL = clickTwoURL;
    }

    @Override
    public String toString() {
        return "TrackVisit{" + "baseURL=" + baseURL + " titlePageBase=" + titlePageBase +
                " clickOneURL=" + clickOneURL + "clickTwoURL" + clickTwoURL + "}";
    }

}
