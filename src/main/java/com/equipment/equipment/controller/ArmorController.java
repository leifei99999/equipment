package com.equipment.equipment.controller;

import com.equipment.equipment.entity.Armor;
import com.equipment.equipment.service.ArmorService;
import com.equipment.equipment.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.*;

@RestController
@RequestMapping("/suit")
public class ArmorController extends BaseController{

    /**
     * 上传文件夹的名称
     */
//    private static final String UPLOAD_DIR_NAME = "./src/main/resources/static/image/";
    private static final String UPLOAD_DIR_NAME = "D:/image/";
//    /**
//     * 上传文件的最大大小
//     */
//    private static final long FILE_MAX_SIZE = 10 * 1024 * 1024;
//
//    /**
//     * 允许上传的文件类型
//     */
//    private static final List<String> FILE_CONTENT_TYPES
//            = new ArrayList<>();
//
//    /**
//     * 初始化允许上传的文件类型的集合
//     */
//    static {
//        FILE_CONTENT_TYPES.add("image/jpeg");
//        FILE_CONTENT_TYPES.add("image/png");
//    }




    @Autowired
    ArmorService usersService;


    /**
     * 插入数据users表
     * @param users 数据对象
     */
    @RequestMapping(value = "/addArmor")
    public ResponseResult<Void> addDate(@RequestBody Armor users ){
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        users.setId(uuid);
        usersService.addUsers(users);
        return new ResponseResult<Void>(SUCCESS,"插入数据成功！");
    }

    /**
     * 查询全部数据
     * @return
     */
    @RequestMapping("/listArmor")
    public  ResponseResult<List<Armor>> listUsers(@RequestBody Armor armor){

            List<Armor> list = usersService.listUsers(armor);
           /* for (Armor users : list){
                System.out.println(users.getServicePic().getImg());
             }*/
        return new ResponseResult<List<Armor>>(SUCCESS,list);
    }

    /**
     * 查询表中最后一条数据
     */
    @RequestMapping("/ArmorData")
    public ResponseResult<List<Armor>> usersData(@RequestBody Armor armor){

        Armor users = usersService.usersData(armor);
        List<Armor> list = new ArrayList<Armor>();
        list.add(users);

        return new ResponseResult<List<Armor>>(SUCCESS,list);
    }

    /**
     * 修改状态信息
     */
    @RequestMapping("/updateState")
    public ResponseResult<Void> usersState(@RequestBody Armor armor){
        usersService.usersState(armor.getId(),armor.getState());
        return new ResponseResult<>(SUCCESS,"更新成功！");
    }




    /**
     * 模糊查询
     * @param equipment
     * @return
     */
    @RequestMapping("/blurryGetAr")
    public ResponseResult<List<Armor>> blurryGet(@RequestBody Armor equipment){
       // System.out.println(equipment.getUsername());
       // System.out.println(equipment.getAffiliationcOmpany()+"/////////////");
       // System.out.println(equipment.getRinseService()+"---------");
        List<Armor> getmh = usersService.getm(equipment);

        //System.out.println(getmh.get(0).getUsername());
        return new ResponseResult<List<Armor>>(SUCCESS,getmh);
    }

    @RequestMapping("/getState")
    public ResponseResult<List<Armor>> getState(@RequestBody Armor armor){
        List<Armor> f = usersService.getF(armor);
        return new ResponseResult<List<Armor>>(SUCCESS,f);
    }


    /**
     * 查询全部数据
     * @return
     */
    @RequestMapping("/getToId")
    public  ResponseResult<List<Armor>> getToId(@RequestBody Armor armor){

        List<Armor> list = usersService.selecid(armor);

        return new ResponseResult<List<Armor>>(SUCCESS,list);
    }


    @RequestMapping("/getSuitDataByCode")
    public  ResponseResult<List<Armor>> getDataByCode(@RequestBody Armor armor){

        List<Armor> list = usersService.getDataByCode(armor);

        return new ResponseResult<List<Armor>>(SUCCESS,list);
    }





    /*@RequestMapping("upRecordImages")
    @ResponseBody
    public ResponseResult<Armor> upRecordImages(@RequestBody Armor armor){
        //创建数组接收图片信息
        MultipartFile[] file = new MultipartFile[armor.getData().size()];
//        System.out.println("id： "+armor.getId());
        //处理base64数据转文件
        for (int i=0; i<armor.getData().size();i++){
            String Image = armor.getData().get(i);
//            System.out.println("base64数据： "+Image);
            if(!Image.equals(null)){
                file[i] = base64ToMultipart.base64ToMultipart(Image);
            }else {
                break;
            }
        }
//        //判断并处理图片信息
//        if (armor.getData().size()>10){
//            return new ResponseResult<Void>(500,"上传失败！图片张数大于10");
//        }else {
//
//        }

//        System.out.println("文件个数： "+file.length);
        File folder = new File(UPLOAD_DIR_NAME);
        if(!folder.exists()){
            folder.mkdirs();
        }

        //保存图片
        if (file.length>0){
            for (int i = 0;i<file.length;i++){
//                System.out.println("文件名称： "+file[i].getOriginalFilename());
                //将文件名称写入Armor.RecordImages属性中
                String[]  st = file[i].getOriginalFilename().split("\\.");
                System.out.println(file[i].getOriginalFilename());
                armor.setRecordImage(armor.getRecordImage()+"##"+st[0]);

                //1定义要上传文件 的存放路径
                String localPath= UPLOAD_DIR_NAME;
                //2获得文件名字
                String fileName=st[0]+".jpg";
                //指定文件位置
                File aa = new File(localPath,fileName);
                //保存图片
                try {
                    file[i].transferTo(aa);
                } catch (IOException e) {
                    return new ResponseResult<>(1,"上传失败！请重试");
                } finally {
                    file.clone();
                }

            }
        }
        file.clone();
        Armor user = usersService.upRecordImages(armor);
//        System.out.println(armor.getRecordImage());
        return new ResponseResult<>(0,user);
    }
*/
    /**
     * 修改维修信息
     */
   /* @RequestMapping("upService")
    @ResponseBody
    public ResponseResult<Void> upService(@RequestBody Armor armor){
        usersService.upInsert(armor);
        return new ResponseResult<>(0,"修改成功！");
    }*/


}












/**
 * 新增加一个类用来添加虚拟路径映射
 */
@Configuration
class MyPicConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**").addResourceLocations("file:/D:/image/");
    }
}
