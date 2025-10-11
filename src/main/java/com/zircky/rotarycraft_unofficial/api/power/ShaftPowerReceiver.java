package com.zircky.rotarycraft_unofficial.api.power;

public interface ShaftPowerReceiver extends PowerAcceptor {
  public void setOmega(int omega);

  public void setTorque(int torque);

  public void setPower(long power);

  public void noInputMachine();

}
