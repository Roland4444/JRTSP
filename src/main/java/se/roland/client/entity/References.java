package se.roland.client.entity;

public enum References {

    Car("Car", "Модель автомобиля"),
    Metal("Metal", "Тип металла");

    private final String table;
    private final String title;

    References(String t, String tit) {
        table = t;
        title = tit;
    }

    public String getTable() {
        return table;
    }

    public String getTitle() {
        return title;
    }

}
