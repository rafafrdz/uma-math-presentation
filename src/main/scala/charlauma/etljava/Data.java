package charlauma.etljava;

class Data {

    int id;
    String value;

    Data(int id, String value) {
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
