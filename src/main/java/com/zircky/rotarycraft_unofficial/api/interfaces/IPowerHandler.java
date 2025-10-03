package com.zircky.rotarycraft_unofficial.api.interfaces;

public interface IPowerHandler {
  /** Get the current rotation speed (RAD/s or rpm depending on the implementation) */
  long getOmega();

  /** Get the current torque */
  long getTorque();

  /** Set values */
  void setPower(long torque, long omega);

  /** Can this block take power */
  boolean canReceive();
}
