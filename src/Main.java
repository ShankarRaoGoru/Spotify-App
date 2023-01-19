import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static List<Album> albums=new ArrayList<>();
    public static void main(String[] args) {
        Album album1=new Album("magical","DSP");
        album1.addSongtoAlbum("oo antava",5.45);
        album1.addSongtoAlbum("neeti mullai",3.40);
        album1.addSongtoAlbum("evipuga",2.43);

        Album album2=new Album("mass","Thaman");
        album2.addSongtoAlbum("123",5.33);
        album2.addSongtoAlbum("jai",4.43);

        albums.add(album1);
        albums.add(album2);

        System.out.println(album1.findSong("evipuga"));
        System.out.println(album1.findSong("33"));

        LinkedList<Song> myplaylist=new LinkedList<>();
        album1.addtoPlaylistFromAlbum("oo antava",myplaylist);
        album2.addtoPlaylistFromAlbum(1,myplaylist);
        album1.addtoPlaylistFromAlbum(2,myplaylist);
        album2.addtoPlaylistFromAlbum("123",myplaylist);
        //Song sample=new Song("adc",5.2);
       // System.out.println(sample);

        play(myplaylist);
    }
    public static void play(LinkedList<Song>playlist){
        Scanner sc=new Scanner(System.in);
        ListIterator itr=playlist.listIterator();
        boolean isForward=false;
        if(playlist.size()>0){
            System.out.println("currently playing:");
            System.out.println(itr.next());
            isForward=true;
        }else{
            System.out.println("playlist is empty");

        }
        System.out.println("enter your choice");
        printMenu();
        boolean quit=false;
        while(!quit){
            int choice=sc.nextInt();
            switch(choice){
                case 1:
                    if (isForward == false) {
                        itr.next();
                        isForward=true;
                    }
                    if(itr.hasNext()){
                        System.out.println(itr.next());
                    }else{
                        System.out.println("reached end of plalist");
                        isForward=false;
                    }
                    break;
                case 2:
                    if(isForward==true){
                        itr.previous();
                        isForward=false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println(itr.previous());
                    }else{
                        System.out.println("you are at start of playlist");
                        isForward=true;
                    }
                    break;
                case 3:
                    if(isForward==true){
                        if(itr.hasPrevious()){
                            System.out.println(itr.previous());
                            isForward=false;
                        }else{
                            System.out.println("song doesnt exist");
                        }
                    }
                    else{
                        if(itr.hasNext()){
                            System.out.println(itr.hasNext());
                            isForward=true;
                        }
                        else{
                            System.out.println("song doesnt exist");
                        }
                    }
                    break;
                case 4:
                    printMenu();
                    break;
                case 5:

                itr.remove();
                    System.out.println("song is deleted successfully");
                    break;
                case 6:
                    printSongs(playlist);
                case 7:
                    quit=true;
                    break;
            }
        }

    }
    public static void printSongs(LinkedList<Song>playlist){
        for(Song s:playlist){
            System.out.println(s);
        }

    }
    public static void printMenu(){
        //System.out.println("select your choice");2
        System.out.println("1-Play next song");
        System.out.println("2-play previous song");
        System.out.println("3-repeat the current song");
        System.out.println("4-show menu again");
        System.out.println("5-Delete the song");
        System.out.println("6-show all the songs in playlist");
        System.out.println("7-Exit");
    }
}