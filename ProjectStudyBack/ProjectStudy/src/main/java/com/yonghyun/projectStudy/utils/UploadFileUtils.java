package com.yonghyun.projectStudy.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
	private static final Logger logger = LoggerFactory.getLogger(UploadFileUtils.class);
	private static Integer WIDTH_SIZE = 100;
	
	public static Integer getWIDTH_SIZE(){
		return WIDTH_SIZE;
	}
	
	public static void setWIDTH_SIZE(Integer widthSize){
		WIDTH_SIZE = widthSize;
	}
	// 1.파일의 저장 경로(uploadPath), 2.원본 파일의 이름(originalName), 3.파일 데이터(byte[])
	public static String uploadFile(String uploadPath, String originalName, byte[] fileData) throws Exception{
	      //★ 1. 고유값 생성
		UUID uid =UUID.randomUUID();
	    String savedName=uid.toString()+"_"+originalName;
	      
	    //★ 2. 년/월/일' 정보 생성
	    String savedPath=calcPath(uploadPath);
	      
	    //★ 3. 원본파일 저장
	    File target =new File(uploadPath+savedPath, savedName);
	    FileCopyUtils.copy(fileData, target);
	         
	    //★ 4. 이미지 일경우 썸네일 이미지 생성 후 url 주소로 반환
	    String formatName=originalName.substring(originalName.lastIndexOf(".")+1);
	    String uploadedFileName=null;
	       
	    if(MediaUtils.getMediaType(formatName)!=null){
	        //이미지일 경우 썸네일 생성 후 이미지 이름 반환 ( 경로+년월일+s_이름)
	        uploadedFileName=makeThumbnail(uploadPath, savedPath, savedName);
	    }else{
	        uploadedFileName=makeIcon(uploadPath, savedPath, savedName);
	    }        
	    // 파일 경로를  -> url 경로로 변경해서 반환
	    return uploadedFileName;  
	}
    // 이미지가 아닐경우  단지 파일 경로를 -> url 경로로 변경해서 반환
    private static String makeIcon(String uploadPath, String savedPath, String savedName) {
        String iconName=uploadPath+savedPath+File.separator+savedName;
        return iconName.substring(uploadPath.length()).replace(File.separatorChar, '/');
    }
 
 
    //파일이 저장될  '년/월/일' 정보 생성
    private static String calcPath(String uploadPath){  
        Calendar cal =Calendar.getInstance();
        // 역슬래시 + 2017
        String yearPath=File.separator + cal.get(Calendar.YEAR);
         
        //  /2017 +/+ 10  한자리 월 일경우 01, 02 형식으로 포멧
        String monthPath=yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
         
        // /2017/10 +/ + 22 
        String datePath = monthPath+ File.separator+ new DecimalFormat("00").format(cal.get(Calendar.DATE));
         
        //년월일 폴더 생성하기
        makeDir(uploadPath, yearPath, monthPath, datePath);
         
        logger.info(" datePath - {}", datePath);
         
        return datePath;
    }
 
     
    // 실질 적인 날짜 폴더 생성
    private static void makeDir(String uploadPath, String... paths){    
        if(new File(paths[paths.length-1]).exists()){
            //년 월 일 에서 일 배열 paths 에서 paths -1 은 일  즉 해당일의 폴더가 존재하면 return
            return ;
        }
         
        for(String path :paths){
            File dirPath =new File(uploadPath+path);
            if(!dirPath.exists()){
                //년 월일에 대한 해당 폴더가 존재하지 않으면 폴더 생성
                dirPath.mkdir();
            }
        }
         
    }
     
    //썸네일 이미지 생성하기
    // 1.파일 경로 2. 년월일 경로, 3. 파일 이름 
    private static String makeThumbnail(String uploadPath, String path, String fileName) throws Exception{
        // 파일 존재하는 이미지를 메모리상 이미지에 올려 붙인다. 즉 메모리에 로딩시킨다.
        BufferedImage sourceImg= ImageIO.read(new File(uploadPath+path, fileName));
         
        //메모리상 이미지를 정해진 크기에 맞게 복사한다.
        BufferedImage destImage=Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC,
                Scalr.Mode.FIT_TO_HEIGHT, WIDTH_SIZE);
         
        //썸네일 이미지 이름을 정한다. 썸네일 이미지를 앞에 s_ 붙인다.
        String thumbnailName=uploadPath+path+File.separator+"s_"+fileName;
         
        // 파일 경로의 객체를 생성한다.
        File newFile=new File(thumbnailName);
         
        // 경로의 마지막 에 . 으로 중심으로 분리해서 .jpg, png, jpeg gif 의 문자를 추출한다.  
        String formatName=fileName.substring(fileName.lastIndexOf(".")+1);
         
        //실질적인 썸네일 이미지를 복사한다.  
        ImageIO.write(destImage, formatName.toUpperCase(), newFile);
     
        // 파일 경로인 역슬러시를 url 의 경로인 슬러시로 변경해서 해서 반환시킨다.
        return thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/');
    }

}
