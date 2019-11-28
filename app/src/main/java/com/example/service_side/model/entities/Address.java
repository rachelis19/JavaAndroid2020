package com.example.service_side.model.entities;

import java.util.Objects;

public class Address
    {
        private String city;
        private String state;

        public Address()
        {
            city = "?";
            state = "?";
        }

        public String getCity()
        {
            return city;
        }

        public String getState()
        {
            return state;
        }

        public void setCity(String aCity)
        {
            city = aCity;
        }
        public void setState(String aState)
        {
            state = aState;
        }

        public String toString()
        {
            return city + "," + state;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Address address = (Address) o;
            return Objects.equals(city, address.city) &&
                    Objects.equals(state, address.state);
        }

        @Override
        public int hashCode() {
            return Objects.hash(city, state);
        }
    }

