package cn.itcast.ssm.utils;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * @Author: gofocus
 * @Date: 8:44 2019/8/25
 */
public class CountDown {
    private int limitSec;
    private int curSec;
    public CountDown(int limitSec) throws InterruptedException{
        this.limitSec = limitSec;
        Timer timer = new Timer();
        timer.schedule(new TimerTask(){
            public void run(){

                System.out.println("倒计时结束，拍卖结束");
            }
        },limitSec * 1000);
        TimeUnit.SECONDS.sleep(limitSec);
        timer.cancel();
        System.out.println("Time is out!");
    }
    //Test
/*	public static void main(String[] args) throws InterruptedException{
		new CountDown2(10);
	}*/

}
