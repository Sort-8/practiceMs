package com.ruoyi.practiceScore.domain;

public class Calculate {
    private int punchDay;
    private int logDay;
    private String username;

    @Override
    public String toString() {
        return "Calculate{" +
                "punchDay=" + punchDay +
                ", logDay=" + logDay +
                ", username='" + username + '\'' +
                '}';
    }

    public int getPunchDay() {
        return punchDay;
    }

    public void setPunchDay(int punchDay) {
        this.punchDay = punchDay;
    }

    public int getLogDay() {
        return logDay;
    }

    public void setLogDay(int logDay) {
        this.logDay = logDay;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
