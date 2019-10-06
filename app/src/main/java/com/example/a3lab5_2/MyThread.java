package com.example.a3lab5_2;

public class MyThread extends Thread {
  private int progress = 0;
  private int id;


  public interface MyInterface {
    void updateStatus(int progress, int id);
  }

  public MyThread(MyInterface MyInterface, int i) {
    callBackInterface = MyInterface;
    id = i;
  }

  MyInterface callBackInterface = null;

  public void run() {
    try {
      while (progress < 100) {
        progress = progress + 10;
        callBackInterface.updateStatus(progress, id);
        sleep(3000);
      }
    }catch (Exception e){
      e.printStackTrace();
    }


  }

}
