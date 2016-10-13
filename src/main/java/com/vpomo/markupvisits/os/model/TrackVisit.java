package com.vpomo.markupvisits.os.model;

/**
 * Created by Pomogalov on 12.10.2016.
 */
public class TrackVisit {
    private String baseURL;
    private String titlePageBase;
    private String clickOneURL;
    private String clickTwoURL;
    private String clickThreeURL;
    private String clickFourURL;

    public TrackVisit() {
        this.baseURL = null;
        this.titlePageBase = null;
        this.clickOneURL = null;
        this.clickTwoURL = null;
        this.clickThreeURL = null;
        this.clickFourURL = null;
    }

    public TrackVisit(String baseURL, String titlePageBase, String clickOneURL,
                      String clickTwoURL, String clickThreeURL, String clickFourURL) {
        this.baseURL = baseURL;
        this.titlePageBase = titlePageBase;
        this.clickOneURL = clickOneURL;
        this.clickTwoURL = clickTwoURL;
        this.clickThreeURL = clickThreeURL;
        this.clickFourURL = clickFourURL;
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

    public String getClickThreeURL() {
        return clickThreeURL;
    }

    public void setClickThreeURL(String clickThreeURL) {
        this.clickThreeURL = clickThreeURL;
    }

    public String getClickFourURL() {
        return clickFourURL;
    }

    public void setClickFourURL(String clickFourURL) {
        this.clickFourURL = clickFourURL;
    }


    @Override
    public String toString() {
        return "TrackVisit{" + "baseURL=" + baseURL + " titlePageBase=" + titlePageBase +
                " clickOneURL=" + clickOneURL + "clickTwoURL" + clickTwoURL +
                " clickThreeURL=" + clickThreeURL + " clickFourURL=" + clickFourURL + "}";
    }

}
