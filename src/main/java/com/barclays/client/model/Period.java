package com.barclays.client.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class Period {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("effective_from")
    private Date from;

    @JsonProperty("rates")
    private Rate rate;

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public static class Rate {

        private Float standard;

        public Float getStandard() {
            return standard;
        }

        public void setStandard(float standard) {
            this.standard = standard;
        }
    }

}
