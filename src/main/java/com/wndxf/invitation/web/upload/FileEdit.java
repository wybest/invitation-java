package com.wndxf.invitation.web.upload;

import com.wndxf.invitation.GlobalDefine;
import com.wndxf.invitation.persistence.UsersDAO;
import com.wndxf.invitation.persistence.model.Users;
import com.wndxf.invitation.web.Base;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author wy
 */
@Controller
public class FileEdit extends Base {

    @RequestMapping(value="uploadBackground", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> uploadBackground(HttpServletRequest request,HttpSession session) {
        Map<String, Object> returnMap = new HashMap<>();
        LinkedList<FileMeta> files = new LinkedList<>();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultiValueMap<String, MultipartFile> multiValueMap = multipartRequest.getMultiFileMap();
        MultipartFile file = (MultipartFile) ((LinkedList) multiValueMap.values().toArray()[0]).get(0);
        String folder = GlobalDefine.getFolderName();
        String oldSuffix = file.getOriginalFilename().split("\\.")[1];
        String fileName = folder+"/"+GlobalDefine.getFileName()+"."+oldSuffix;
        String target = file.getName();
        File targetFile = new File(GlobalDefine.getImagePath(), fileName);

        //保存
        try {

            FileMeta fileMeta = new FileMeta();
            fileMeta.setName(file.getOriginalFilename());
            fileMeta.setSize(file.getSize());
            fileMeta.setType(file.getContentType());
            fileMeta.setThumbnail_url("/img?filename=" + fileName);
            fileMeta.setDelete_url("/deleteImg?filename=" + fileName);
            fileMeta.setDelete_type("GET");
            files.add(fileMeta);
            File tempFile;
            String deleteFile;
            Users oldUser = getUser(session);
            String[] images = oldUser.getBackground().split(",");
            Users user = new Users();
            user.setId(getUserId(session));
            switch (target){
                case "file1":
                    //删除文件
                    deleteFile = images[0];
                    images[0] = fileName;
                    saveFile(user,images,file,targetFile,deleteFile);
                    break;
                case "file2":
                    deleteFile = images[1];
                    images[1] = fileName;
                    saveFile(user,images,file,targetFile,deleteFile);
                    break;
                case "file3":
                    deleteFile = images[2];
                    images[2] = fileName;
                    saveFile(user,images,file,targetFile,deleteFile);
                    break;
                case "file4":
                    deleteFile = images[3];
                    images[3] = fileName;
                    saveFile(user,images,file,targetFile,deleteFile);
                    break;

            }
            returnMap.put("files",files);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnMap;
    }

    private void saveFile(Users user,String[] images,MultipartFile file,File targetFile,String deleteFile) throws IOException {
        GlobalDefine.deleteFile(new File(GlobalDefine.imagePath+deleteFile));
        user.setBackground(GlobalDefine.getBackground(images));
        usersDAO.update(user);
        FileCopyUtils.copy(file.getBytes(), new FileOutputStream(targetFile));
    }

    @RequestMapping(value="upload", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> upload(MultipartHttpServletRequest request,HttpSession session) {
        LinkedList<FileMeta> files = new LinkedList<>();
        Map<String, Object> returnMap = new HashMap<>();
        //1. build an iterator
        Iterator<String> itr =  request.getFileNames();
        MultipartFile mpf;

        //2. get each file
        while(itr.hasNext()){
            //2.1 get next MultipartFile
            mpf = request.getFile(itr.next());

            //2.2 if files > 10 remove the first from the list
            if(files.size() >= 10)
                files.pop();

            //2.3 create new fileMeta
            String folder = GlobalDefine.getFolderName();
            String oldSuffix = mpf.getOriginalFilename().split("\\.")[1];
            String fileName = folder+"/"+GlobalDefine.getFileName()+"."+oldSuffix;
            FileMeta fileMeta = new FileMeta();
            fileMeta.setName(fileName);
            fileMeta.setSize(mpf.getSize());
            fileMeta.setType(mpf.getContentType());
            fileMeta.setThumbnail_url("/img?filename="+fileMeta.getName());
            fileMeta.setDelete_url("/deleteImg?filename="+fileMeta.getName());
            fileMeta.setDelete_type("GET");
            try {
                //并发问题,最好是放到session里，但是这里量不大，就来个全局锁，大并发性能有问题
                //问题是同时间读出来的image是一样的，这样不同线程就会丢数据
                GlobalDefine.lock.lock();
                try {
                    Users oldUser = getUser(session);
                    String imageStr = oldUser.getImage() == null || oldUser.getImage().length() == 0 ? fileName : oldUser.getImage() + "," + fileName;
                    String[] len = imageStr.split(",");
                    if (len.length > 30) {
                        return returnMap;
                    }
                    oldUser.setImage(imageStr);
                    usersDAO.update(oldUser);
                }finally {
                        GlobalDefine.lock.unlock();
                    }
                // copy file to local disk (make sure the path "e.g. D:/temp/files" exists)
                FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(GlobalDefine.getImagePath()+fileName));

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //2.4 add to files
            files.add(fileMeta);
        }
        // result will be like this
        // [{"fileName":"app_engine-85x77.png","fileSize":"8 Kb","fileType":"image/png"},...]
        returnMap.put("files",files);
        return returnMap;
    }

    @RequestMapping(value = "images", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> images(HttpSession session){
        LinkedList<FileMeta> files = new LinkedList<>();
        Map<String, Object> returnMap = new HashMap<>();
        Users user = getUser(session);
        if(StringUtils.isNotEmpty(user.getImage())){
            String[] images = user.getImage().split(",");
            for (String image:images){
                FileMeta fileMeta = new FileMeta();
                fileMeta.setName(image);
                fileMeta.setThumbnail_url("/img?filename="+fileMeta.getName());
                fileMeta.setDelete_url("/deleteImg?filename="+fileMeta.getName());
                fileMeta.setDelete_type("GET");
                files.add(fileMeta);
            }

        }
        returnMap.put("files",files);
        return returnMap;
    }

    @RequestMapping(value = "check")
    public @ResponseBody
    Map<String, Object> check(){
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("success","ok");
        return returnMap;
    }

    @RequestMapping(value = "img", method = RequestMethod.GET)
    public void img(HttpServletResponse response,@RequestParam("filename") String filename){
        try {
            response.setContentType("image/"+filename.split("\\.")[1]);
            response.setHeader("Content-disposition", "attachment; filename=\""+filename+"\"");
            File file = new File(GlobalDefine.imagePath+filename);
            FileInputStream inputStream = new FileInputStream(file);
            FileCopyUtils.copy(inputStream, response.getOutputStream());
        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "deleteImg", method = RequestMethod.GET)
    public void deleteImg(HttpServletResponse response,@RequestParam("filename") String filename,HttpSession session){
        try {
            File file = new File(GlobalDefine.getImagePath()+filename);
            GlobalDefine.deleteFile(file);
            Users oldUser = getUser(session);
            String imageStr = oldUser.getImage()==null?"":oldUser.getImage();
            String[] images = imageStr.split(",");
            imageStr = "";
            for(String image:images){
                if(!image.equals(filename)){
                    imageStr += image+",";
                }
            }
            imageStr = imageStr.length()==0?imageStr:imageStr.substring(0,imageStr.length()-1);
            oldUser.setImage(imageStr);
            usersDAO.update(oldUser);
            response.getOutputStream().write("success".getBytes());
        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
