package uma.charla.etl;

class JData {

    int id;
    String value;

    JData(int id, String value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
