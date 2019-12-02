package com.example.service_side.data.model.entities;


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
            if (!(o instanceof Address)) return false;
            Address address = (Address) o;
            return getCity().equals(address.getCity()) &&
                    getState().equals(address.getState());
        }


    }

