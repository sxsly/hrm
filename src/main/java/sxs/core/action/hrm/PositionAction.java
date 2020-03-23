package sxs.core.action.hrm;

import org.springframework.context.ApplicationContext;
import sxs.core.service.hrm.PositionService;
import sxs.core.util.hrm.ApplicationUtil;
import sxs.core.vo.hrm.PositionVo;
import sxs.core.vo.hrm.ResultInfoVo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Author: shang
 * Create Data: 2020/3/14/014
 */
public class PositionAction {
    private ApplicationContext context = ApplicationUtil.getApplicationContext();

    /**
     * 查询职位信息
     * @return
     */
    public ResultInfoVo getPositionInfo(PositionVo positionVo){
        ResultInfoVo resultInfo = new ResultInfoVo();
        PositionService positionService = context.getBean(PositionService.class);
        resultInfo.setPageIndex(positionVo.getPageIndex());
        resultInfo.setPageSize(4);

        positionVo.setPageColumn(resultInfo.getPageColumn());
        positionVo.setPageSize(resultInfo.getPageSize());

        try {
            Integer totalRecords = positionService.getPositionCount(positionVo);
            resultInfo.setTotalRecords(totalRecords);
            List<PositionVo> positionVoList = positionService.getPositionInfo(positionVo);
            resultInfo.setFlag(true);
            resultInfo.setData(positionVoList);
        }catch (Exception e){
            e.printStackTrace();
            resultInfo = new ResultInfoVo(false,null,"系统异常，请稍后重试");
        }
        return resultInfo;
    }

    /**
     * 修改职位信息
     * @param positionVo
     * @return
     */
    public ResultInfoVo updatePositionInfo(PositionVo positionVo){
        ResultInfoVo resultInfo = null;
        PositionService positionService = context.getBean(PositionService.class);
        try {
            Integer row = positionService.updatePositionInfo(positionVo);
            if (row > 0){
                resultInfo = new ResultInfoVo(true,row,null);
            } else {
              resultInfo = new ResultInfoVo(false,null,"修改失败，该记录不存在或已删除！");
            }
        }catch (Exception e){
            resultInfo = new ResultInfoVo(false,null,"系统异常，请稍后重试");
        }

        return resultInfo;
    }

    /**
     * 删除职位信息
     * @param positionVo
     * @return
     */
    public ResultInfoVo deletePositionInfo(PositionVo positionVo){
        ResultInfoVo resultInfo = null;
        PositionService positionService = context.getBean(PositionService.class);
        try {
            Integer row = positionService.deletePositionInfo(positionVo);
            if (row > 0){
                resultInfo = new ResultInfoVo(true,row,null);
            } else {
                resultInfo = new ResultInfoVo(false,null,"删除失败，该记录不存在！");
            }
        }catch (Exception e){
            resultInfo = new ResultInfoVo(false,null,"系统异常，请稍后重试");
        }

        return resultInfo;
    }

    /**
     * 添加职位信息
     * @param positionVo
     * @return
     */
    public ResultInfoVo addPositionInfo(PositionVo positionVo){
        ResultInfoVo resultInfo = null;
        PositionService positionService = context.getBean(PositionService.class);
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        positionVo.setCreateTime(sm.format(new Date()));
        try {
            Integer row = positionService.addPositionInfo(positionVo);
            if (row > 0){
                resultInfo = new ResultInfoVo(true,row,null);
            } else {
                resultInfo = new ResultInfoVo(false,null,"添加失败！");
            }
        } catch (Exception e){
            e.printStackTrace();
            resultInfo = new ResultInfoVo(false,null,"系统异常，请稍后重试");
        }

        return resultInfo;
    }

    /**
     * 查询所有职位
     * @param positionVo
     * @return
     */
    public ResultInfoVo getAllPosition(PositionVo positionVo){
        ResultInfoVo resultInfo = null;
        PositionService positionService = context.getBean(PositionService.class);

        try {
            List<PositionVo> positionVoList = positionService.getAllPosition(positionVo);
            resultInfo = new ResultInfoVo(true,positionVoList,null);
        } catch (Exception e){
            e.printStackTrace();
            resultInfo = new ResultInfoVo(false,null,"系统异常，请稍后重试");
        }

        return resultInfo;
    }
}
