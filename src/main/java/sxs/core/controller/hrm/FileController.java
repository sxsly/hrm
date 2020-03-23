package sxs.core.controller.hrm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sxs.core.service.hrm.DocumentService;
import sxs.core.vo.hrm.DocumentVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

/**
 * Author: shang
 * Create Data: 2020/3/19/019
 */
@Controller
@ResponseBody
public class FileController {
    @Autowired
    private DocumentService documentService;

    /**
     * 上传文件
     */
    @RequestMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile mFile, HttpServletRequest request){
        String result = null;
        if (!mFile.isEmpty()){
            String path = "F://upload";
            String filename = System.currentTimeMillis()+mFile.getOriginalFilename();

            File file = new File(path,filename);
            if (!new File(path).exists()){
                file.mkdirs();
            }
            try {
                mFile.transferTo(file);
                result = file.getPath();
            } catch (IOException e) {
                e.printStackTrace();
                result = "fail";
            }
        }
        return result;
    }

    /**
     * 文件下载
     */
    @RequestMapping("/downloadFile")
    public void downloadFile(HttpServletResponse response,Integer id) throws Exception {
        // 根据id查找对应的文件名
        DocumentVo dmVo = new DocumentVo();
        dmVo.setId(id);
        List<DocumentVo> voList = documentService.getDocumentInfo(dmVo);
        DocumentVo vo = null;
        if (!voList.isEmpty()){
            vo = voList.get(0);
        }

        String fileName = vo.getFileName();
        String filePath = vo.getFilePath();
        File file = new File(filePath);
        fileName = URLEncoder.encode(fileName,"UTF-8");
        //通知浏览器已下载的方式打开
        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        InputStream in = new FileInputStream(file);
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) != -1){
            out.write(buffer,0,len);
            out.flush();
        }
        out.close();
    }
}
