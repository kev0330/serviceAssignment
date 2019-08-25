package cput.ac.za.domain.demographic;

import java.util.Objects;

public class Race {


    private String race, raceId;


    private Race(){
    }

    public String getRace() {
        return race;
    }

    public String getRaceId() {
        return raceId;
    }

    private Race(Builder builder){
        this.raceId = builder.raceId;
        this.race = builder.race;
    }


    public static class Builder{

        private String race, raceId;

        public Builder race(String race){
            this.race = race;
            return this;
        }

        public Builder raceId (String raceId){
            this.raceId = raceId;
            return this;
        }

        public Builder copy(Race race) {
            this.raceId = race.raceId;
            this.race = race.race;
            return this;
        }

        public Race build(){
            return new Race(this);
        }
    }


    @Override
    public String toString() {
        return "Race{" +
                "raceId='" + raceId + '\'' +
                ", raceName='" + race + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return raceId.equals(race.raceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raceId);
    }
}
