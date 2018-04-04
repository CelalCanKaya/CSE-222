package com.company;

import java.util.Objects;

/**
 * Dosyadan okudugum course bilgilerini sakladıgım class. Getter ve setterlardan olustugu için diğer metodlarını acıklamayacagım.
 */
public class Courses {
    private int semester;
    private String courseCode;
    private String courseTitle;
    private int ectsCredit;
    private int gtuCredit;
    private String htl;
    private boolean isEnabled;

    public Courses() {
        this.semester = 0;
        this.courseCode = "";
        this.courseTitle = "";
        this.ectsCredit = 0;
        this.gtuCredit = 0;
        this.htl = "";
        this.isEnabled = true;
    }

    public Courses(int semester, String courseCode, String courseTitle, int ectsCredit, int gtuCredit, String htl, boolean isEnabled) {
        this.semester = semester;
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.ectsCredit = ectsCredit;
        this.gtuCredit = gtuCredit;
        this.htl = htl;
        this.isEnabled = isEnabled;
    }


    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public int getEctsCredit() {
        return ectsCredit;
    }

    public void setEctsCredit(int ectsCredit) {
        this.ectsCredit = ectsCredit;
    }

    public int getGtuCredit() {
        return gtuCredit;
    }

    public void setGtuCredit(int gtuCredit) {
        this.gtuCredit = gtuCredit;
    }

    public String getHtl() {
        return htl;
    }

    public void setHtl(String htl) {
        this.htl = htl;
    }

    public boolean isEnabled() { return isEnabled; }

    public void setEnabled(boolean enabled) { isEnabled = enabled; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Courses courses = (Courses) o;
        return semester == courses.semester &&
                ectsCredit == courses.ectsCredit &&
                gtuCredit == courses.gtuCredit &&
                Objects.equals(courseCode, courses.courseCode) &&
                Objects.equals(courseTitle, courses.courseTitle) &&
                Objects.equals(htl, courses.htl);
    }


    @Override
    public String toString() {
        return "Courses{" +
                "semester=" + semester +
                ", courseCode='" + courseCode + '\'' +
                ", courseTitle='" + courseTitle + '\'' +
                ", ectsCredit=" + ectsCredit +
                ", gtuCredit=" + gtuCredit +
                ", htl='" + htl + '\'' +
                '}' + '\n';
    }


}
