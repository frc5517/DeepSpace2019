package frc.robot.utilities;

import java.util.HashMap;
import java.util.Map;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class LogitechJoystick extends Joystick {

    private final static int TRIGGER_BUTTON = 1;
    private Map<Integer, JoystickButton> buttonMap = new HashMap<>();
    
    public LogitechJoystick(int port) {
        super(port);
    }

    public JoystickButton getTriggerJoystickButton() {
        return getJoystickButton(TRIGGER_BUTTON);
    }
    
    public boolean isTriggerPressed() {
        return getTriggerJoystickButton().get();
    }

    public JoystickButton getJoystickButton(int buttonId) {
        if(buttonMap.containsKey(buttonId)) {
            return buttonMap.get(buttonId);
        }
        return new JoystickButton(this, buttonId);
    }
}