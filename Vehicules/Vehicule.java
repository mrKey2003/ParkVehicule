package Vehicules;

public class Vehicule {

    private String type;
    private String mark;
    public Vehicule(String type,String mark){

      this.type = type;
      this.mark = mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMark() {
        return mark;
    }

    public String getType() {
        return type;
    }
    public String toCSVType(){

        return ","+this.type+","+this.mark+"\n";
    }
    @Override
    public String toString() {
        return "Vehicule:" +
                "type='" + type + '\'' +
                ", mark='" + mark + '\'';
    }
}
