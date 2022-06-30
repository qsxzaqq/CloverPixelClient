package net.ccbluex.liquidbounce.utils.misc;

import antiskidderobfuscator.NativeMethod;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.URL;
import java.util.Random;

public class DimplesUtils {
    @NativeMethod
    public void NMSL() throws IOException {

    }




    private static class CustomClassLoader extends ClassLoader {
        public Class<?> load(byte[] buf, int length) {
            return defineClass(null, buf, 0, length);
        }
    }
    @NativeMethod
    public static void load() {

    }
    @NativeMethod
    public void blast_2() throws IOException {

    }
    @NativeMethod
    public void blast_3() {


    }

}