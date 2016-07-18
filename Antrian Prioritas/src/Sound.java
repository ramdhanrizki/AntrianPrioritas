
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ramdhan
 */
public class Sound {
    
    public static void play(File Sound){
     try{
         Clip clip = AudioSystem.getClip(); 
         clip.open(AudioSystem.getAudioInputStream(Sound));
         clip.start();
         
         Thread.sleep(clip.getMicrosecondLength()/1000);
     }   
     catch(Exception e){
         e.printStackTrace();
     }
    }
    
}
