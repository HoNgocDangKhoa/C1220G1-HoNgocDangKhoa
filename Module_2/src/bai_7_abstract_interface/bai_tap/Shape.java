package bai_7_abstract_interface.bai_tap;

public class Shape {
    private String color;
    private boolean filled;

    public Shape() {
        color = "green";
        filled=true;
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return
                "màu sắc là :  "
                        +getColor() +"\n"+
                        (isFilled() ?  "lấp đầy" : "chưa lấp đầy " );
    }
}
