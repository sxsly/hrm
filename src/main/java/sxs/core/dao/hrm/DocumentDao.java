package sxs.core.dao.hrm;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sxs.core.vo.hrm.DocumentVo;

import java.util.List;

/**
 * Author: shang
 * Create Data: 2020/3/19/019
 */
@Mapper
public interface DocumentDao {
    // 查询文件信息
    public List<DocumentVo> getDocumentInfo(DocumentVo documentVo);

    // 添加文档信息
    public Integer addDocumentInfo(DocumentVo documentVo);

    // 查询记录总数
    public Integer getDocumentCount(DocumentVo documentVo);

    // 修改
    public Integer updateDocumentInfo(DocumentVo documentVo);
}
