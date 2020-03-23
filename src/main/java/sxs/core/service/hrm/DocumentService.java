package sxs.core.service.hrm;

import sxs.core.vo.hrm.DocumentVo;

import java.util.List;

/**
 * Author: shang
 * Create Data: 2020/3/19/019
 */
public interface DocumentService {
    /**
     * 查找文件信息
     */
    public List<DocumentVo> getDocumentInfo(DocumentVo documentVo);

    /**
     * 上传文档
     */
    public Integer addDocumentInfo(DocumentVo documentVo);

    /**
     * 查询记录总数
     */
    public Integer getDocumentCount(DocumentVo documentVo);

    /**
     * 修改文档信息
     */
    public Integer updateDocumentInfo(DocumentVo documentVo);
}
