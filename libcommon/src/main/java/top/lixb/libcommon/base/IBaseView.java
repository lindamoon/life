package top.lixb.libcommon.base;

/**
 * 基础状态接口
 */
public interface IBaseView {
    void showLoading();

    void hideLoading();

    void showEmpty();

    void showError();

    void showSuccess();
}
