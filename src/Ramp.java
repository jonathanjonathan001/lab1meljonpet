
public class Ramp {

    public Ramp(RampState currentRampState) {
        this.currentRampState =  currentRampState;
    }

    public enum RampState {UP,DOWN}
    private RampState currentRampState;

    /**
     * returns the current state of the ramp
     * @return current state of the ramp
     */
    public RampState getCurrentRampState() {
        return currentRampState;
    }

    public void setCurrentRampState(RampState state){
        currentRampState = state;
    }
}
