import java.awt.*;

// car interface

interface CarInterface {
    int getNrDoors();
    double getEnginePower();
    double getCurrentSpeed();
    Color getColor();
    void setColor(Color clr);
    void startEngine();
    void stopEngine();

}
