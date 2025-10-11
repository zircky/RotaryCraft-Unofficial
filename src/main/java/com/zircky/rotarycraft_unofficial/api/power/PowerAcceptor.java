package com.zircky.rotarycraft_unofficial.api.power;

public interface PowerAcceptor {
//  public boolean canReadFrom(ForgeDirection dir);

  public boolean isReceiving();

  public int getMinTorque(int available);

}
