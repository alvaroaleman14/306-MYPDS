package org.alvaroaleman.practica3;

public class DummyAdvertiser implements AdvertiserDatabase {
    public DummyAdvertiser(){
        super();
    }

    @Override
    public boolean findAdviser(String adviserName) {
        throw new RuntimeException("Dummy");
    }
}
