package frc.robot.utilities;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class LogitechJoystick extends Joystick {

    private final static int TRIGGER_BTN = 1;
    
    public LogitechJoystick(int port) {
        super(port);
    }

    public JoystickButton getTriggerButton() {
        return getJoystickButton(TRIGGER_BTN);
    }

    public JoystickButton getJoystickButton(int btn) {
        return new JoystickButton(this, btn);
    }
}