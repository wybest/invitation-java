package com.wndxf.invitation;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wy
 */
public class GlobalDefine {

    private static AtomicInteger _clientIdSeed = new AtomicInteger(0);
    public static Lock lock = new ReentrantLock();
    public static String errorMessage="errorMessage";
    public static String message="message";
    public static String user="user";
    public static String admin="admin";
    public static String ERROR = "error";
    public static String MESSAGE = "message";
    public static String imagePath;
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
    private static SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    public static String IMAGE_URL = "/img?filename=";
    public static String[] mp3Names = new String[58];
    public static String[] mp3Ids = new String[58];
    public static int getUniqueId() {
        return _clientIdSeed.getAndIncrement();
    }

    static {

        mp3Names[0] = "无音乐";//1
        mp3Ids[0] = "11";

        mp3Names[1] = "23(feat. miley cyrus, wiz khalifa & juicy j).mp3";//1
        mp3Ids[1] = "23(feat. miley cyrus, wiz khalifa & juicy j).mp3";

        mp3Names[2] = "17171771  紫雨林.mp3";//2
        mp3Ids[2] = "2.mp3";

        mp3Names[3] = "A-Little-Love.mp3";//3
        mp3Ids[3] = "A-Little-Love.mp3";

        mp3Names[4] = "Beautiful In White.mp3";//4
        mp3Ids[4] = "Beautiful In White.mp3";

        mp3Names[5] = "Bruno Mars - Marry You .mp3";//5
        mp3Ids[5] = "Bruno Mars - Marry You .mp3";

        mp3Names[6] = "Bruno Mars - The Lazy Song.mp3";//6
        mp3Ids[6] = "Bruno Mars - The Lazy Song.mp3";

        mp3Names[7] = "Carpenters - Yesterday Once More.mp3";//7
        mp3Ids[7] = "Carpenters - Yesterday Once More.mp3";

        mp3Names[8] = "chris-brown-you-with.mp3";//8
        mp3Ids[8] = "chris-brown-you-with.mp3";

        mp3Names[9] = "couldThisBeLove.mp3";//9
        mp3Ids[9] = "couldThisBeLove.mp3";

        mp3Names[10] = "Darin - Cant Stop Love.mp3";//10
        mp3Ids[10] = "10.mp3";

        mp3Names[11] = "Everyday.mp3";//11
        mp3Ids[11] = "Everyday.mp3";

        mp3Names[12] = "I Know I Loved You (Live).mp3";//12
        mp3Ids[12] = "I Know I Loved You (Live).mp3";

        mp3Names[13] = "I-Love-You.mp3";//13
        mp3Ids[13] = "I-Love-You.mp3";

        mp3Names[14] = "IDo.mp3";//14
        mp3Ids[14] = "IDo.mp3";

        mp3Names[15] = "John Michael Montgomery-I Swear.mp3";//15
        mp3Ids[15] = "John Michael Montgomery-I Swear.mp3";

        mp3Names[16] = "Jumping Into Rivers.mp3";//16
        mp3Ids[16] = "Jumping Into Rivers.mp3";

        mp3Names[17] = "space-love .mp3";//17
        mp3Ids[17] = "space-love .mp3";

        mp3Names[18] = "Tattim-aw.mp3";//18
        mp3Ids[18] = "Tattim-aw.mp3";

        mp3Names[19] = "we can work it out.mp3";//19
        mp3Ids[19] = "we can work it out.mp3";

        mp3Names[20] = "今天你要嫁给我.mp3";//20
        mp3Ids[20] = "20.mp3";

        mp3Names[21] = "可爱的韩国儿歌-三只小熊.mp3";//21
        mp3Ids[21] = "21.mp3";

        mp3Names[22] = "同桌的你.mp3";//22
        mp3Ids[22] = "22.mp3";

        mp3Names[23] = "吴建豪-小婚礼.mp3";//23
        mp3Ids[23] = "23.mp3";

        mp3Names[24] = "咕叽之歌.mp3";//24
        mp3Ids[24] = "24.mp3";

        mp3Names[25] = "坐在巷口的那对男女.mp3";//25
        mp3Ids[25] = "25.mp3";

        mp3Names[26] = "夜的钢琴曲.mp3";//26
        mp3Ids[26] = "26.mp3";

        mp3Names[27] = "小夫妻.mp3";//27
        mp3Ids[27] = "27.mp3";

        mp3Names[28] = "小野丽莎-可爱的你.mp3";//28
        mp3Ids[28] = "28.mp3";

        mp3Names[29] = "幸福恋人.mp3";//29
        mp3Ids[29] = "29.mp3";


        mp3Names[30] = "心肝宝贝.mp3";//30
        mp3Ids[30] = "30.mp3";

        mp3Names[31] = "恩典的记号.mp3";//31
        mp3Ids[31] = "31.mp3";

        mp3Names[32] = "我们结婚吧.mp3";//32
        mp3Ids[32] = "32.mp3";


        mp3Names[33] = "方大同 - Nothing’s Gonna Change My Love For You.mp3";//33
        mp3Ids[33] = "33.mp3";

        mp3Names[34] = "最重要的决定.mp3";//34
        mp3Ids[34] = "34.mp3";

        mp3Names[35] = "爱很美.mp3";//35
        mp3Ids[35] = "35.mp3";

        mp3Names[36] = "纯音乐-梦中的婚礼.mp3";//36
        mp3Ids[36] = "36.mp3";

        mp3Names[37] = "终于等到你.mp3";//37
        mp3Ids[37] = "37.mp3";

        mp3Names[38] = "给你们.mp3";//38
        mp3Ids[38] = "38.mp3";

        mp3Names[39] = "胡俊逸-我的笑脸.mp3";//39
        mp3Ids[39] = "39.mp3";

        mp3Names[40] = "苏打绿-无与伦比的美丽.mp3";//40
        mp3Ids[40] = "40.mp3";

        mp3Names[41] = "谢谢爱.mp3";//41
        mp3Ids[41] = "41.mp3";

        mp3Names[42] = "钢琴曲 - 清新的婚礼轻音乐.mp3";//42
        mp3Ids[42] = "42.mp3";

        mp3Names[43] = "陈慧琳 - Love Paradise.mp3";//43
        mp3Ids[43] = "43.mp3";

        mp3Names[44] = "陶喆-爱很简单.mp3";//44
        mp3Ids[44] = "44.mp3";

        mp3Names[45] = "青春纪念册.mp3";//45
        mp3Ids[45] = "45.mp3";

        mp3Names[46] = "德国童音.mp3";//46
        mp3Ids[46] = "46.mp3";

        mp3Names[47] = "Cuppy Cake Song.mp3";//47
        mp3Ids[47] = "47.mp3";

        mp3Names[48] = "夫妻相.mp3";//48
        mp3Ids[48] = "48.mp3";

        mp3Names[49] = "爸爸去哪儿.mp3";//49
        mp3Ids[49] = "49.mp3";

        mp3Names[50] = "幸福-盛晓玫.mp3";//50
        mp3Ids[50] = "50.mp3";

        mp3Names[51] = "稳稳的幸福.mp3";//51
        mp3Ids[51] = "51.mp3";

        mp3Names[52] = "来自星星的你.mp3";//52
        mp3Ids[52] = "52.mp3";

        mp3Names[53] = "Chris Medina - What Are Words .mp3";//53
        mp3Ids[53] = "53.mp3";

        mp3Names[54] = "i'm yours.mp3";//54
        mp3Ids[54] = "54.mp3";

        mp3Names[55] = "就是爱你.mp3";//55
        mp3Ids[55] = "55.mp3";

        mp3Names[56] = "王力宏&章子怡-爱一点.mp3";//56
        mp3Ids[56] = "56.mp3";

        mp3Names[57] = "光阴的故事.mp3";//56
        mp3Ids[57] = "57.mp3";
    }

    public static String getFolderName(){
        String path = format.format(new Date());
        File filPath = new File(imagePath+path);
        if(!filPath.exists()){
            filPath.mkdirs();
        }
        return path;
    }

    public static String getFileName(){
        return format1.format(new Date())+"-"+GlobalDefine.getUniqueId();
    }

    public static void setImagePath(String imagePath) {
        GlobalDefine.imagePath = imagePath;
    }

    public static String getImagePath(){
        return GlobalDefine.imagePath;
    }

    public static boolean deleteFile(File file){
        if(file.isFile()){
            file.delete();
            return true;
        }else{
            return false;
        }
    }

    public static String getBackground(String[] images){
        String ims = "";
        for (String image:images){
            ims += image+",";
        }
        return ims;
    }
}
