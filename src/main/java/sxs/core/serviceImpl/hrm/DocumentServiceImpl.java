package sxs.core.serviceImpl.hrm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sxs.core.dao.hrm.DocumentDao;
import sxs.core.service.hrm.DocumentService;
import sxs.core.vo.hrm.DocumentVo;

import java.util.List;

/**
 * Author: shang
 * Create Data: 2020/3/19/019
 */
@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentDao documentDao;

    @Override
    public List<DocumentVo> getDocumentInfo(DocumentVo documentVo) {
        return documentDao.getDocumentInfo(documentVo);
    }

    @Override
    public Integer addDocumentInfo(DocumentVo documentVo) {
        return documentDao.addDocumentInfo(documentVo);
    }

    @Override
    public Integer getDocumentCount(DocumentVo documentVo) {
        return documentDao.getDocumentCount(documentVo);
    }

    @Override
    public Integer updateDocumentInfo(DocumentVo documentVo) {
        return documentDao.updateDocumentInfo(documentVo);
    }
}
