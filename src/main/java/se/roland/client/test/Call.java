package se.roland.client.test;

import com.sun.jna.Library;
import com.sun.jna.Native;

public class Call {
    public interface CLibrary extends Library {
        public static final CLibrary INSTANCE = (CLibrary) Native.loadLibrary("sek", CLibrary.class);

        void initBuff(int size);
        void updateBuf(int val);
        int getitem(int index);
    }

    public void initBuff(int i){
        CLibrary.INSTANCE.initBuff(i);
    }


    public void updateBuf(int val){
        CLibrary.INSTANCE.updateBuf(val);
    }
    public int getitem(int index){
        return CLibrary.INSTANCE.getitem(index);
    }



    public static void main(String[] args) {
        Call t = new Call();
        t.initBuff(500);
        t.updateBuf(15);
        System.out.println(t.getitem(20));

    }
}