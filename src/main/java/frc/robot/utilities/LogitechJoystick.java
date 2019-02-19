package frc.robot.utilities;

import java.util.HashMap;
import java.util.Map;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class LogitechJoystick extends Joystick {

    public final static int TRIGGER_BUTTON = 1;
    public static final int BUTTON_2 = 2;
    public static final int BUTTON_3 = 3;
    public static final int BUTTON_4 = 4;
    public static final int BUTTON_5 = 5;
    public static final int BUTTON_6 = 6;
    public static final int BUTTON_7 = 7;
    public static final int BUTTON_8 = 8;
    public static final int BUTTON_9 = 9;
    public static final int BUTTON_10 = 10;
    public static final int BUTTON_11 = 11;
    public static final int BUTTON_12 = 12;
    public Map<Integer, JoystickButton> buttonMap = new HashMap<>();
    
    public LogitechJoystick(int port) {
        super(port);
    }

    public JoystickButton getJoystickTrigger() {
        return getJoystickButton(TRIGGER_BUTTON);
    }
    
    public boolean isBoostButtonPressed() {
        return getJoystickButton(BUTTON_2).get();
    }

    public JoystickButton getJoystickButton(int buttonId) {
        if(buttonMap.containsKey(buttonId)) {
            return buttonMap.get(buttonId);
        }
        return new JoystickButton(this, buttonId);
    }
}